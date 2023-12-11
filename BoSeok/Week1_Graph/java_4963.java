package BoSeok.Week1_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class java_4963 {
    static int w, h, count;
    static int[][] graph;
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, 1}, {-1, -1}, {1, 1}, {1, -1}};
    static int nx, ny;
    static Queue<Node> Q = new LinkedList<Node>();

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int x, int y) {
        Q.offer(new Node(x, y));
        graph[x][y] = 0; // 방문

        while (!Q.isEmpty()) {
            Node node = Q.poll();
            for (int[] direction : move) {
                int dx = direction[0];
                int dy = direction[1];

                nx = node.x + dx;
                ny = node.y + dy;

                if (0 <= nx && nx < h && 0 <= ny && ny < w && graph[nx][ny] == 1) {
                    graph[nx][ny] = 0;
                    Q.offer(new Node(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            w = Integer.parseInt(stk.nextToken());
            h = Integer.parseInt(stk.nextToken());

            if (w == 0 && h == 0) {
                break;
            }
            graph = new int[h][w];
            for (int i = 0; i < h; i++) {
                stk = new StringTokenizer(bf.readLine()); // 한줄 읽어
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(stk.nextToken());
                }
            }

            count = 0;
            for (int x = 0; x < h; x++) { // 2
                for (int y = 0; y < w; y++) { // 3
                    if (graph[x][y] == 1) {
                        bfs(x, y);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
