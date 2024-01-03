package BoSeok.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class java_1193_분수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int a = 0;
        int b = 0;
        int line = 1;

        while (n > line) {
            n -= line;
            line += 1;
        }
//        짝수 라인이면 위에서 내려옴
        if (line % 2 == 0) {
            a = n;
            b = line - n + 1;
        }
//        홀수 라인이면 아래 에서
        else {
            a = line - n + 1;
            b = n;
        }
        System.out.println(a + "/" + b);
    }
}
