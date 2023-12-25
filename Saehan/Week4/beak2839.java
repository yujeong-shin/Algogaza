import java.util.Scanner;

public class beak2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        while (true) {
            if (N % 5 != 0) {
                N = N - 3;
                count++;
            } else if (N < 0) {
                System.out.println(-1);
                break;
            } else if (N % 5 == 0) {
                count += N / 5;
                System.out.println(count);
                break;
            }
        }
    }
}