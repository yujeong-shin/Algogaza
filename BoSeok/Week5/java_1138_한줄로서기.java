package BoSeok.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class java_1138_한줄로서기 {
    static int n;
    static int[] res ;

    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        res = new int[n];
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        List<Integer> lst = IntStream.rangeClosed(0, n-1)
                        .mapToObj(i->Integer.parseInt(stk.nextToken()))
                        .collect(Collectors.toList());

        IntStream.rangeClosed(0, n - 1).forEach(x->{
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (count == lst.get(x) && res[j] == 0) {
                    res[j] = x + 1;
                    break;
                } else if (res[j] == 0) {
                    count++;
                }
            }
        });
        Arrays.stream(res).forEach(x-> System.out.print(x+" "));
    }
}
