package BoSeok.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.StringTokenizer;


public class Main {
    static int n,m,k,c;
    static int[] lst;
    static int left, right;
    static int res = (int) -1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        Hashtable<Integer, Integer> dic = new Hashtable<>();
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        lst = new int[n];

        for (int i = 0; i < n; i++) {
            lst[i] = Integer.parseInt(bf.readLine());
        }

//        딕셔너리 초기값, 쿠폰은 무조건 들어감
        dic.put(c, 1);
        for (int i = 0; i < k; i++) {
            int value = lst[i];
            dic.put(value, dic.getOrDefault(value, 0) + 1);
        }
//        투포인터, 왼쪽 , 오른쪽 설정
        left = 0;
        right = k - 1;

        for (int i = 0; i < n; i++) {
            res = Math.max(res, dic.size());
            int l_value = lst[i];
//            맨 왼쪽 한칸 움직이면서 -1 해주기
            dic.put(l_value, dic.getOrDefault(l_value, 0) - 1);
            if (dic.get(l_value) == 0) {
                dic.remove(l_value);
            }
//            왼쪽 값, 오른쪽 값 옮김
            left += 1;
            right += 1;
//            오른쪽 값 최신화
            int r_valut = lst[right % n];
            dic.put(r_valut, dic.getOrDefault(r_valut, 0) +1);
        }
        System.out.println(res);
    }
}
