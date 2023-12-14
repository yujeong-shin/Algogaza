package BoSeok.Week3_Graph;

import BoSeok.Week2_Graph.java_7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class java_2636 {
    static int n, m, nx, ny, time, count, melt, meltedCount;
    static int[][] graph;
    static int[][] move = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static Queue<Node> Q = new LinkedList<Node>();

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
/* 1 갯수 세기 코드
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    count ++;
                }
            }
        }
        */
//        2. 갯수세기 코드 스트림
        long count = Arrays.stream(graph)
                .flatMapToInt(Arrays::stream) // 2차원 배열을 1차원 배열로 평탄화
                .filter(value -> value == 1) // 0인 요소만 필터링
                .count(); // 개수 세기

        // 걸린 시간
        time = 1;

        while (true) {
            visited = new boolean[n][m];
            melt = bfs();
            count -= melt;
            // 다 녹았으면
            if (count == 0) {
//                다 녹기전으로 출력해준다.
                System.out.print(time + " " + melt);
                break;
            }
            time++;
        }
    }

//    Q 2개 사용해서 풀기, 1개도 가넝
    private static int bfs() {
        Q.add(new Node(0, 0));
        visited[0][0] = true;
        Queue<Node> M_Q = new LinkedList<Node>();
        meltedCount = 0;
        while (!Q.isEmpty()) {
            Node node = Q.poll();

            for (int[] direction : move) {
                nx = node.x + direction[0];
                ny = node.y + direction[1];
                // 방문 안 했으면

                if (0 <= nx && nx < n && 0 <= ny && ny < m && visited[nx][ny] == false) {
                    // 방문처리
                    visited[nx][ny] = true;

                    // 아직 공기중임
                    if (graph[nx][ny] == 0) {
                        // 1 찾을때까지 출발
                        Q.add(new Node(nx, ny));
                    } else if (graph[nx][ny] == 1) {
                        // 1을 만나면 녹이는 리스트에 넣어야함
                        M_Q.add(new Node(nx, ny));
                        meltedCount++;
                    }
                }
            }
        }

        // 녹이고 나서 녹인 노드들 0 으로 바꿔줘야함.
        while (!M_Q.isEmpty()) {
            Node node = M_Q.poll();
            graph[node.x][node.y] = 0;
        }
        // 녹인 크기 return
        return meltedCount;
    }
}
