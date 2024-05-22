package BoSeok.Week0521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class java_11404 {
    static int n, m, u, v, e;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        m = Integer.parseInt(bufferedReader.readLine());

//        자기 자신으로는 못감 ->0 나머지는 최댓값
        int[][] graph = IntStream.range(0, n)
                .mapToObj(i -> IntStream.range(0, n)
                        .map(j -> i == j ? 0 : INF)
                        .toArray())
                .toArray(int[][]::new);
//        System.out.println(Arrays.deepToString(graph));

//        u -> v 로 가는 거리 저장해줌, e가 최솟값이 아닐 수 도 있음
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[u - 1][v - 1] = Math.min(e, graph[u - 1][v - 1]);
        }
//        x - > y  는 x ->k -> y 랑 비교를 한다.

        IntStream.range(0, n).forEach(k ->
                IntStream.range(0, n).forEach(x ->
                        IntStream.range(0, n).forEach(y -> {
                            if (graph[x][k] != INF && graph[k][y] != INF) {
                                if (graph[x][y] >= graph[x][k] + graph[k][y]) {
                                    graph[x][y] = graph[x][k] + graph[k][y];

                                }
                            }
                        })
                )
        );
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == Integer.MAX_VALUE) {
                    graph[i][j] = 0;
                }

                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}