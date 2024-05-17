import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_15663 {
    static int[] temp;
    static int[] comb;
    static boolean[] check;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        temp = new int[n];
        check = new boolean[n];
        comb = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(temp);

        func(0);
        System.out.println(sb);
    }

    static void func(int depth) throws IOException {
        if(depth == m) {
            for(int a : comb) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for (int i = 0; i < n; i++) {
            if(!check[i] && before != temp[i]) {
                check[i] = true;
                comb[depth] = temp[i];
                before = temp[i];
                func(depth + 1);
                check[i] = false;
            }
        }
    }
}
