package HiJaeYoung.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num11726_N타일링 {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        memo = new int[1001];
        memo[1] =1;
        memo[2]= 2;
        dp(n);
        System.out.println(memo[n]);
    }
    public static int dp(int n){
        if(memo[n]!=0){
            return memo[n];
        }
        memo[n] = dp(n-1)+dp(n-2);
        return memo[n]%=10007;
    }
}
