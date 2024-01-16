// N과 M (1)

import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_15649 {
    static List<Integer> list = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        check = new boolean[n+1];

        seq(n, m);
    }
    static void seq(int n, int m) throws IOException {
        if(list.size() == m) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for(int a : list) {
                bw.write(a + " ");
            }
            bw.write("\n");
            bw.flush();
        }

        for(int i=1; i<=n; i++) {
            if(!check[i]) {
                check[i] = true;
                list.add(i);
                seq(n, m);
                list.remove(list.size()-1);
                check[i] = false;
            }
        }

    }
}
