import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2096_내려가기 {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][3];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int maxValue = getMaxValue(new int[3]);
        int minvalue = getMinValue(new int[3]);
        System.out.println(maxValue + " " + minvalue);

    }
    public static int getMaxValue(int[] dp){
        dp[0] = map[0][0];
        dp[1] = map[0][1];
        dp[2] = map[0][2];

        for(int i=1; i<N; i++){
            int temp0 = dp[0];
            int temp1 = dp[1];
            int temp2 = dp[2];

            dp[0] = Math.max(temp0, temp1) + map[i][0];
            dp[1] = Math.max(Math.max(temp0, temp1),temp2) + map[i][1];
            dp[2] = Math.max(temp1, temp2) + map[i][2];
        }
        return Math.max(Math.max(dp[0], dp[1]), dp[2]);
    }
    public static int getMinValue(int[] dp){
        dp[0] = map[0][0];
        dp[1] = map[0][1];
        dp[2] = map[0][2];

        for(int i=1; i<N; i++){
            int temp0 = dp[0];
            int temp1 = dp[1];
            int temp2 = dp[2];

            dp[0] = Math.min(temp0, temp1) + map[i][0];
            dp[1] = Math.min(Math.min(temp0, temp1),temp2) + map[i][1];
            dp[2] = Math.min(temp1, temp2) + map[i][2];
        }
        return Math.min(Math.min(dp[0], dp[1]), dp[2]);
    }
}
