package BoSeok.Week3_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java_16953 {

    static long start, target;
    static int res = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        start = Integer.parseInt(stk.nextToken());
        target = Integer.parseInt(stk.nextToken());
        dfs(start, 0);
        System.out.println(res);
    }

    private static void dfs(long node, int count) {
        if (node == target) {
            res = count + 1;
        }
        if (node < target) {
            dfs(node * 2, count + 1);
            dfs((node * 10) + 1, count + 1);
        }
    }
}
