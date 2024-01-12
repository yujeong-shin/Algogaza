import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex2293_동전1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int target = Integer.parseInt(st.nextToken());
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int a : arr) {
            for (int j = a; j <= target; j++) {
                dp[j] += dp[j - a];
            }
        }
        System.out.println(dp[target]);
    }
}
