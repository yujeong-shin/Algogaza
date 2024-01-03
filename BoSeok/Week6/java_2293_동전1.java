package BoSeok.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class java_2293_동전1 {
    static int n, k;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.valueOf(bf.readLine()));
        }
        list.sort(Comparator.naturalOrder());

        dp = new int[k + 1];

        dp[0] = 1;

//        코인들을 오름차순으로 정렬해줌.
//        가장 작은 코인들을 사용해서 만드는 경우부터 하나씩 추가해줌
//        1,2,5 일때 1로는 10개 다 만들 수 있다.
//        2일경우는 3은 2+1, 5는 2+3, 4+1 , 5,

//        dp[j] = 가치의 합이 j이 되도록 하는 경우의 수 누적합
//        coins = 5 예시 일때 ,dp[5] =  5원 되도록 하는 경우의 수 + 현재 5원 1개
//        dp[6] = dp[6] + dp[1] >> 1원 만드는데 필요한 갯수 + 현재5원 :: >> 두개 더하면 6원 임
        for (int coin : list) {
            for (int j = coin; j < k + 1; j++) {
                dp[j] += dp[j - coin];
            }
        }
        System.out.println(dp[k]);
    }
}
