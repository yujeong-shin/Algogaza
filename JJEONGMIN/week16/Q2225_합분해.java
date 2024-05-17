import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2225_합분해 {
    static long[][] dp = new long[201][201];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // A: 목표로하는 숫자, B: 자리 수
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        // dp[a][b] = dp[a-1][b] + dp[a][b-1];
        long result = hap(A, B);

        System.out.println(result % 1000000000);
    }
    public static long hap(int A, int B){
        if(A == 0) return dp[A][B] = 1;
        if(B == 1) return dp[A][B] = 1;
        if(dp[A][B] != 0) return dp[A][B];
        return dp[A][B] = (hap(A-1, B) % 1000000000) + (hap(A, B-1) % 1000000000);
    }
}
