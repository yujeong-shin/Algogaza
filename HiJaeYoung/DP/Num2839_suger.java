package HiJaeYoung.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Num2839_suger {
    static int[] vist;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        vist = new int[5001];
        vist[3] = 1;
        vist[5] =1;
        vist[n]=dp(n);
        if(vist[n] >=2000){
            System.out.println(-1);
        }else{
            System.out.println(vist[n]);
        }
        //System.out.println(Arrays.toString(vist));
    }
    public static int dp(int n) {
        if(n<3){
            return 2000;
        }
        if(n==3) return 1;
        if(n<5) return 2000;
        if(n==5) return 1;
        if(vist[n]!=0) return vist[n];
        vist[n] = Math.min(dp(n-5)+1,dp(n-3)+1);
        return vist[n];
    }
}
