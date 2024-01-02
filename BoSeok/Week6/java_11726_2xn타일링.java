package BoSeok.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.System.exit;

public class java_11726_2xn타일링 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        dp = new int[n + 2];
        dp[1] = 1 ;
        dp[2] = 2 ;
        if (n <= 2) {
            System.out.println(dp[n]);
            exit(0);
        }
        IntStream.range(3, n+1).forEach(i -> dp[i] = (dp[i - 1] + dp[i - 2])%10007);
        System.out.println(dp[n]);
    }
}
