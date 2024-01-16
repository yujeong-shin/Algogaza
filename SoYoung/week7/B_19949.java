// 영재의 시험

import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_19949 {
    static int[] arr = new int[10];
    static Stack<Integer> st = new Stack<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int depth = -1;

        func(depth);

        System.out.println(count);
    }
    static void func(int depth) {
        if(st.size() == 10) {
            int score = 0;
            for(int i=0; i<10; i++) {
                if(arr[i] == st.elementAt(i)) {
                    score++;
                }
            }
            if(score >= 5) {
                count++;
            }
            return;
        }
        for(int i=1; i<=5; i++) {
            if(depth >= 1) {
                if(st.elementAt(depth) == i && st.elementAt(depth-1) == i) {
                    continue;
                }
            }
            st.push(i);
            func(depth+1);
            st.pop();
        }
    }
}
