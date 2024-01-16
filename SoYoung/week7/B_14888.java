// 연산자 끼워넣기

import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_14888 {
    static int[] num;
    static int[] op;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[n];
        for(int i=0; i<n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        op = new int[4];
        for(int i=0; i<4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        int depth = 0;

        func(n, depth, num[0]);

        System.out.println(max + "\n" + min);

    }
    static void func(int n, int depth, int result) {
        if(depth == n-1) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        for(int i=0; i<4; i++) {
            if(op[i] == 0) continue;
            int oper = result;
            switch (i) {
                case 0 :
                    oper += num[depth+1];
                    break;
                case 1 :
                    oper -= num[depth+1];
                    break;
                case 2 :
                    oper *= num[depth+1];
                    break;
                case 3 :
                    oper /= num[depth+1];
                    break;
            }
            op[i]--;
            func(n, depth+1, oper);
            op[i]++;
        }
    }
}
