package BoSeok.Week4;

import java.util.Scanner;

public class java_2839 {
    static int n ;
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.next());
        result = 0;
//        아이디어 5로 나누어 질때까지 3을 뺀다.

        while (true) {
            if (n % 5 == 0) {
                result += (n / 5);
                System.out.println(result);
                break;
            } else if (n < 0) {
                System.out.println(-1);
                break;
            }
            n -= 3;
            result += 1;
        }
    }
}
// 파이썬은 while도 else문이 있어서 개꿀인데 이건 없다.
