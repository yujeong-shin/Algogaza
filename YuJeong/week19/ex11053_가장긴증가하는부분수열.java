import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // LIS
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if(arr[i] > arr[j] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
        }
        int answer = 0;
        // 정답 구하기
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
