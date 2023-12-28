package BoSeok.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class java_1051_숫자정사각형 {
    static int n,m;
    static int result = (int) -1e9;
    static int[][] graph;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        graph = new int[n][m];
        System.out.println(Arrays.deepToString(graph));
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine());
            String row = stk.nextToken();
            for (int j = 0; j < m; j++) {
                graph[i][j] = Character.getNumericValue(row.charAt(j));
//                graph[i][j] = stk.nextToken().charAt(j);
            }
        }
        for (int k = 0; k < n + 1; k++) {

            for (int x = 0; x < n; x++) {

                for (int y = 0; y < m; y++) {
                    if (x + k < n && y + k < m && graph[x][y] == graph[x][y + k] && graph[x][y] == graph[x + k][y] && graph[x][y] == graph[x + k][y + k]) {
                        result = Math.max(result, (k + 1) * (k + 1));
                    }
                }
            }
        }
        System.out.println(result);
    }
}
/*
3 5
42101
22100
22101

 */