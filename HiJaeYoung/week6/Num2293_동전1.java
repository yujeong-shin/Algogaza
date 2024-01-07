package HiJaeYoung.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num2293_동전1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i] = Integer.parseInt(bf.readLine());
        }
        // 작은 동전부터 채워나가야 함
        Arrays.sort(coins);
        int[] memo = new int[k+1];
        for(int i=0;i<n;i++){
            // 동전의 금액이 k보다 커지면 스탑
            if(coins[i]>k){
                break;
            }
            memo[coins[i]]+=1;
            for(int j=coins[i]+1;j<=k;j++){
                memo[j] += memo[j-coins[i]];
            }
        }
        System.out.println(memo[k]);

    }
}
