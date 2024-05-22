import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex11722_가장긴감소하는부분수열 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(calc());
    }
    static int calc() {
        int answer = 0;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 0;
        }
        dp[0] = 1;
        // Longest Decreasing Subsequence
        for (int i = 1; i < N; i++) {
            int max=0;
            for (int j = i-1; j >= 0; j--) {
                if(arr[i] < arr[j] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
        }
        // 정답 구하기
        for (int i = 0; i < N; i++) {
//            System.out.println("dp[" + i + "] = " + dp[i]);
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}
