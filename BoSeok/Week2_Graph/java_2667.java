package BoSeok.Week2_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class java_2667 {

    // 단지 번호 붙이기
    // bfs 끝내고 section += 1 때릴예정

    static int n, section, count, dx, dy, nx, ny ;
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] graph;

    static Queue<Node> Q = new LinkedList<Node>();

    static class Node{
        int x ;
        int y ;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine()); // 한 줄 읽기
            String row = stk.nextToken(); //
            for (int j = 0; j < n; j++) {
                graph[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }
        section = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (graph[x][y] == 1) {
                    res.add(bfs(x,y));
                    section += 1;
                }
            }
        }
        System.out.println(res.size());
        res.stream().sorted().forEach(x-> System.out.println(x));
//        forEach(x -> System.out.println(visited[x]))
    }
    private static int bfs(int x, int y) {
        Q.offer(new Node(x, y));
        graph[x][y] = 0; // 방문처리
        count = 1;

        while (!Q.isEmpty()) {
            Node node = Q.poll();

            dx = node.x; dy = node.y;

            for (int[] direction : move) {
                nx = node.x + direction[0];
                ny = node.y + direction[1];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && graph[nx][ny] == 1) {
                    graph[nx][ny] = 0;
                    Q.add(new Node(nx, ny));
                    count += 1;
                }
            }
        }
        return count;
    }
}
