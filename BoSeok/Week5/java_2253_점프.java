package BoSeok.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class java_2253_점프 {
    static int n, m ;
    static double[][] dp ;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        // 등차수열의 합공식 사용해서 근사값을 구함. 예를들어 20인경우 1~6 까지의 합 보다 작음, >> 6까지 체크
        dp = new double[n + 1][(int) (Math.sqrt(2 * n) + 2)];
        // 최댓값으로 초기화
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = Double.POSITIVE_INFINITY;
            }
        }

        // 못 밟는 땅
        Set<Integer> stoneSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            stoneSet.add(Integer.valueOf(bf.readLine()));
        }
//        dp[i번째의돌의][도착속도] 근사값

        dp[1][0] = 0;
        for (int i = 2; i <= n; i++) {
            if (stoneSet.contains(i)) {
                continue;
            }
            for (int j = 1; j <= Math.pow(2 * n, 0.5); j++) {
                // 그대로 가기, -1 줄여서가기, +1 해서 가기
                if (i - j >= 0) {
                    dp[i][j] = Math.min(dp[i - j][j - 1], Math.min(dp[i - j][j], dp[i - j][j + 1])) + 1;

                }
            }
        }

        int result = (int) Arrays.stream(dp[n])
                .min()
                .orElse(Integer.MAX_VALUE);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}