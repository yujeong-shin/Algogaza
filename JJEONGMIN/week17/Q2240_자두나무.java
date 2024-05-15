import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2240_자두나무 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] jaduList = new int[T+1];
        int[][] dp = new int[T+1][W+1];

        for(int i=1; i<=T; i++) {
            st = new StringTokenizer(br.readLine());
            jaduList[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=T; i++){
            int temp = jaduList[i];

            for(int j=0; j<=W; j++){
                if(j == 0){
                    if(temp == 1){
                        dp[i][j] = dp[i-1][j] + 1;
                    }
                } else if(j % 2 == 0){
                    if(temp == 1){
                        dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1]);
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                    }
                }else {
                    if(temp == 2){
                        dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1]);
                    } else{
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                    }
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        System.out.println(result);
    }
}
