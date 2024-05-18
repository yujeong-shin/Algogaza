import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class kebinUser {
    int index, count;
    kebinUser(int index, int count){
        this.index = index;
        this.count = count;
    }
}

public class ex1389_케빈베이컨의6단계법칙 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int answer=0, N, min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        // 연결 정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        // BFS 호출
        for (int i = 1; i <= N; i++) {
            BFS(i);
        }
        System.out.println(answer);
    }
    static void BFS(int start){
        int count=0;
        Deque<kebinUser> deque = new ArrayDeque();
        boolean[] visited = new boolean[N+1];
        deque.add(new kebinUser(start, 0));
        visited[start] = true;
        while(!deque.isEmpty()){
            kebinUser cur = deque.poll();
            for(int next : graph.get(cur.index)) {
                if(!visited[next]) {
                    visited[next] = true;
                    count += cur.count;
                    deque.add(new kebinUser(next, cur.count+1));
                }
            }
        }
        // 정답 구하기
        if(count < min) {
            min = count;
            answer = start;
        }
    }
}
