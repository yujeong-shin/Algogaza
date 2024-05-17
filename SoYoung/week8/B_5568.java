import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_5568 {
    static int[] num;
    static boolean[] check;
    static Set<String> comb = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        num = new int[n];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        func(n, k, "", 0);

        System.out.println(comb.size());

    }

    static void func(int n, int k, String str, int depth) {
        if(depth == k) {
            comb.add(str);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!check[i]){
                check[i] = true;
                func(n, k, str+num[i], depth+1);
                check[i] = false;
            }
        }
    }
}
