import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_10947 {
    static List<Integer> temp = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        check = new boolean[n];

        func(n);
    }

    static void func(int n) {
        if(temp.size() == n) {
            for(int a : temp) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!check[i]){
              check[i] = true;
              temp.add(i+1);
              func(n);
              temp.remove(temp.size()-1);
              check[i] = false;
            }
        }
    }
}
