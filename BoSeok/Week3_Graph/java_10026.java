package BoSeok.Week3_Graph;

import BoSeok.Week2_Graph.java_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class java_10026 {
    static int n, nx, ny, count;
    static String color;
    static String[][] graph;
    static int[][] move = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
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
        n = Integer.parseInt(bf.readLine());
        StringTokenizer stk;

        graph = new String[n][n]; // 그래프
        visited = new boolean[n][n]; // 방문처리

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine()); // 한 줄 읽기
            String row = stk.nextToken(); //
            for (int j = 0; j < n; j++) {
                graph[i][j] = String.valueOf((row.charAt(j)));
            }
        }

//        적록색약 없는 경우
        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false) {
                    bfs(i, j);
                    count += 1;
                }
            }
        }
        System.out.print(count);
//        적록색약 있는경우
        visited = new boolean[n][n];
        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j].equals("R")) {
                    graph[i][j] = "G";
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false) {
                    bfs(i, j);
                    count += 1;
                }
            }
        }
        System.out.print(" ");
        System.out.println(count);
    }
    private static void bfs(int x, int y) {
        visited[x][y] = true;
        Q.add(new Node(x, y));
        color = graph[x][y]; // 색깔 저장
        while (!Q.isEmpty()) {
            Node node = Q.poll();
            for (int[] direction : move) {
                nx = node.x + direction[0];
                ny = node.y + direction[1];
                if (0 <= nx && nx < n && 0 <= ny && ny < n && visited[nx][ny] == false) {
                    if (graph[nx][ny].equals(color)){
                        visited[nx][ny] = true;
                        Q.add(new Node(nx, ny));
                    }
                }
            }
        }
    }
}
//for i in range(n):
//        for j in range(n):
//        if visited[i][j] ==False:
//        bfs(i, j)
//        count += 1
