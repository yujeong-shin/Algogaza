package BoSeok.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class java_2477_참외밭 {
    static int n;

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());

        // 큰 사각형
        int max_w = 0;
        int max_h = 0;

        // 작은사각형
        int min_w = 0;
        int min_h = 0;

//            가장 큰 사각형 넓이 구하기
        for (int i = 0; i < 6; i++) {
            stk = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int a = Integer.parseInt(stk.nextToken());
            list.add(a);
            if (i % 2 == 0) {
                max_w = Math.max(max_w, a);
            } else {
                max_h = Math.max(max_h, a);
            }
        }
//        작은 사각형을 구하기 위해서는
//        같은 번호 사이에 있는 두개의 값이 작은 사각형의 변을 의미한다.
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0 && max_h == list.get((i + 5) % 6) + list.get((i + 1) % 6)) {
                min_w = list.get(i);
            } else if (i % 2 == 1 && max_w == list.get((i + 5) % 6) + list.get((i + 1) % 6)) {
                min_h = list.get(i);
            }
        }
        System.out.println(n * ((max_h * max_w) - (min_w * min_h)));
    }
}
