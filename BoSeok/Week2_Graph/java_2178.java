package BoSeok.Week2_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class java_2178 {

    static int n, m, nx, ny;
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] graph, visited;
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
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        graph = new int[n + 1][m + 1];
        visited = new int[n + 1][m + 1];
        visited[0][0] = 1; // 시작 위치 1
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine()); // 한 줄 읽기
            String row = stk.nextToken(); // 
            for (int j = 0; j < m; j++) {
                graph[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }
        Q.add(new Node(0, 0));

        while (!Q.isEmpty()) {
            Node node = Q.poll();
            if (node.x == n - 1 && node.y == m - 1) {
                System.out.print(visited[node.x][node.y]);
                break;
            }
            for (int[] direction : move) {
                nx = node.x + direction[0];
                ny = node.y + direction[1];

                if (0 <= nx && nx < n && 0 <= ny && 0 < m && visited[nx][ny] == 0 && graph[nx][ny] == 1) {
                    Q.offer(new Node(nx, ny));
                    visited[nx][ny] = visited[node.x][node.y] + 1;
                }
            }
        }
    }
}
