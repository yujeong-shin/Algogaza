package BoSeok.Week5;


import java.io.*;
import java.util.*;

public class java_16234_인구이동 {
    static int n, l, r, day, nx, ny;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] graph;
    static boolean[][] visited;
    static StringTokenizer stk;
    static LinkedList<Node> Q = new LinkedList<Node>();


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
        l = Integer.parseInt(stk.nextToken());
        r = Integer.parseInt(stk.nextToken());

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        while (true) {
            visited = new boolean[n][n];
            boolean flag = false; // 인구이동 체크 flag
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (!visited[x][y]) {
                        if (bfs(x, y) > 1) { // 인구이동 했으면
                            flag = true;  // 인구이동 체크
                        }
                    }
                }
            }
            if (!flag) {
                break;
            }
            day += 1;
        }
        System.out.println(day);
    }

    private static int bfs(int x, int y) {
        Q.add(new Node(x, y));
        visited[x][y] = true;

//        분자
        int up = graph[x][y];

//        분모
        ArrayList<Node> down_list = new ArrayList<Node>();
        down_list.add(new Node(x, y));

        while (!Q.isEmpty()) {
            Node node = Q.poll();
            for (int[] direction : move) {
                int dx = direction[0];
                int dy = direction[1];
                nx = node.x + dx;
                ny = node.y + dy;
                if (0 <= nx && nx < n && 0 <= ny && ny < n && l <= Math.abs(graph[node.x][node.y] - graph[nx][ny]) && Math.abs(graph[node.x][node.y] - graph[nx][ny]) <= r && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    up += graph[nx][ny]; // 분자
                    down_list.add(new Node(nx, ny)); // 분모
                    Q.add(new Node(nx, ny));
                }
            }
        }
//        인구이동 한 좌표들 평균값으로 바꿔줌
        for (Node node : down_list) {
            graph[node.x][node.y] = (int) Math.floor(up / down_list.size());
        }
//        인구이동 한 사람들 숫자 리턴
        return down_list.size();
    }
}
//for i, j in sub_list:
//        graph[i][j] = math.floor(sum_union/ len(sub_list))