package BoSeok.Week1_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class java_11724 {
    static int n, m, count;
    static int[][] graph;
    static boolean[] visited;
    public static void dfs(int node) {
        visited[node] = true;
        for (int i = 1; i <= n; i++) {
            // 방문가능한 지역이고, 아직 방문 안 한 지역이면
            if (graph[node][i] == 1 && !visited[i]) {
                // 호출
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        graph = new int[n + 1][n + 1]; // 1부터 시작하므로 1 추가
        visited = new boolean[n + 1]; // 1 부터 하므로 1 추가

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            graph[x][y] = graph[y][x] = 1; // 양방향
        }
        long count = IntStream.range(1, n + 1) // 1 ~ n까지
                .filter(i -> !visited[i]) // 방문 안 했으면
                .peek(java_11724::dfs)  // dfs 호출, 결과값은 바로 뽑지 않고, 일단 저장
                .count(); // 다 끝나고 나서 카운트 개수 저장
        System.out.println(count);
    }
}
