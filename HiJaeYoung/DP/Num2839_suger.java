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
        if(vist[n] >=5000){
            System.out.println(-1);
        }else{
            System.out.println(vist[n]);
        }
    }
    public static int dp(int n) {
        int answer =0;
        while(n!=0){
            if(n%5==0){
                return answer +=n/5;
            }
            n -=3;
            answer++;
        }
        return answer;
    }
}
