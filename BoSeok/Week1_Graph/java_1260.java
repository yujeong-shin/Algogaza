package BoSeok.Week1_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class java_1260 {
//    전역 변수  하나의 값을 여러 곳에서 일관되게 사용하기 위해
    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int N, M, V;

    //재귀 활용 dfs
    public static void dfs(int V) {
        // start 값 방문 표시
        visited[V] = true;

        // 방문 한 값 데이터
        sb.append(V + " ");

        for (int i = 0; i <= N; i++) {
            // & vs && , & 앞에 거짓이어도 뒤에 검사, && 앞에 진실이면 뒤 검사
            if(graph[V][i] ==1 && !visited[i]){
                // 다음 방문 지역이 존재하고, 방문하지 않았을경우 탐색
                dfs(i);
            }
        }
    }
    private static void bfs(int V) {
        // queue 생성 및, 초치값 설정,
        Queue<Integer> Queue = new LinkedList<>();
        // add는 예외를 반환하고, offer는 false를 반환 기능은 동일
        Queue.add(V);
        visited[V] = true;

        // Q가 빌때까지 while문 실행
        while(!Queue.isEmpty()){
            // 맨 왼쪽 값 뽑아줌,
            int x = Queue.poll();
            sb.append(x + " ");

            for (int i = 0; i <= N; i++) {
                if (graph[x][i] == 1 && !visited[i]) {
                    Queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // 한 줄 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 한 줄 안에서 공백 기준으로 자르기
        StringTokenizer stk = new StringTokenizer(br.readLine());

        // 자른거 하나씩 저장
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        V = Integer.parseInt(stk.nextToken());

        // 2차원 배열 만들기, 기본 값은 0 으로 설정 된디고 한다.
        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            // 양방향
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        // 2차원 리스트 출력 해보기
//        System.out.println(Arrays.deepToString(graph));
        visited = new boolean[N+1];
        dfs(V);

        // 한줄 띄움
        sb.append("\n");

        // visited false 로 초기화
        visited = new boolean[N+1];
        bfs(V);

        System.out.print(sb);

    }
}

