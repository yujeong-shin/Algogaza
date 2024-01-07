package HiJaeYoung.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num2253_Jump {
    static int [][]memo;
    static boolean [] smallStones;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        double dN = (double) n;
        // 최대 가속도 구하는거 너무 화난다ㅠ
        int maxAcc = (int)Math.sqrt(2*dN);
        int k = Integer.parseInt(st.nextToken());
        memo = new int[n+1][maxAcc+2];
        smallStones = new boolean[n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(memo[i],10_001);
        }
        for(int i=0;i<k;i++) {
            int smallStone = Integer.parseInt(bf.readLine());
            smallStones[smallStone] = true;
        }
        memo[1][0] = 0;
        for(int i=2;i<=n;i++){
            if(smallStones[i]) continue;
            for(int j=1;j<(int)Math.sqrt(2*(double)i)+1;j++){
            memo[i][j] = Math.min(memo[i-j][j], memo[i-j][j-1])+1;
            memo[i][j] = Math.min(memo[i-j][j+1]+1,memo[i][j]);
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i =1 ;i<maxAcc+1;i++) {
            answer = Math.min(answer,memo[n][i]);
        }
        if(answer>10_001) answer = -1;
        System.out.println(answer);
    }
}

