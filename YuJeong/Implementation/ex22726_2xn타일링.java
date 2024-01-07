import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex22726_2xn타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001]; // new int[n+1] 로 하면  런타임 에러(ArrayIndexOutOfBounds)나는 이유는?
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}