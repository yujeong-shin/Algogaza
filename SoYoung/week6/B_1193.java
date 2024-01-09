// 분수찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i=1; i<10000; i++) {
            if(x <= 0) break;
            x -= i;
            count++;
        }

        int a = 0; // 분자
        int b = 0; // 분모

        if(count%2 == 0) {
            a = count + x;
            b = count + 1 - a;
        }else {
            b = count + x;
            a = count + 1 - b;
        }

        System.out.println(a + "/" + b);
    }
}