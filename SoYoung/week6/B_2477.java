// 참외밭

import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2477 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> list = new ArrayList<>();
        int k = Integer.parseInt(br.readLine());
        int max_w = 0;
        int max_h = 0;
        int index_w = -1;
        int index_h = -1;

        for(int i=0; i<6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});

            if((a == 1 || a == 2) && max_w < a) {
                max_w = b;
                index_w = i;
            }else if((a == 3 || a == 4) && max_h < a) {
                max_h = b;
                index_h = i;
            }
        }

        int a = 0;
        int b = 0;
        int min_w = 0;
        int min_h = 0;

        if(index_w == 0) {
            a = list.get(5)[1];
            b = list.get(1)[1];
        }else if(index_w == 5) {
            a = list.get(4)[1];
            b = list.get(0)[1];
        }else {
            a = list.get(index_w-1)[1];
            b = list.get(index_w+1)[1];
        }
        min_w = Math.abs(a-b);

        if(index_h == 0) {
            a = list.get(5)[1];
            b = list.get(1)[1];
        }else if(index_h == 5) {
            a = list.get(4)[1];
            b = list.get(0)[1];
        }else {
            a = list.get(index_h-1)[1];
            b = list.get(index_h+1)[1];
        }
        min_h =  Math.abs(a-b);

        System.out.println((max_w * max_h - min_w * min_h) * k);
    }
}
