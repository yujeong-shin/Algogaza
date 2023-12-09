package BoSeok.Week1_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class java_1012 {

    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int t, m, n, k, count;
    static int[][] graph;
    static int nx, ny;
    static Queue<Node> Q = new LinkedList<>();

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            count = 0;
            m = Integer.parseInt(stk.nextToken());
            n = Integer.parseInt(stk.nextToken());
            k = Integer.parseInt(stk.nextToken());
            graph = new int[n][m];

            for (int j = 0; j < k; j++) {
                stk = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                graph[y][x] = 1;
            }

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (graph[x][y] == 1) {
                        bfs(x, y);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Q.offer(new Node(x, y));
        graph[x][y] = 0;
        while (!Q.isEmpty()) {
            Node node = Q.poll();
            for (int[] direction : move) {
                int dx = direction[0];
                int dy = direction[1];

                nx = node.x + dx;
                ny = node.y + dy;
                if (0 <= nx && nx < n && 0 <= ny && ny < m && graph[nx][ny] == 1) {
                    graph[nx][ny] = 0;
                    Q.offer(new Node(nx, ny));
                }
            }
        }
    }
}


// 이렇게만 해야만 하는 이유,,
//            sb.append(count).append('\n');
//                    }
//                    System.out.println(sb);
//                    }


