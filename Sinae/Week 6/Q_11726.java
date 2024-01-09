import java.util.Scanner;

public class Q_11726 {
    //    fibonacci
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int given = Integer.parseInt(sc.nextLine());
        int[] fib = new int[given + 1];
        for (int g = 0; g < given + 1; g++) {
            fib[g] = -1;
        }
        int m = 10007;
        for (int i = 1; i < given + 1; i++) {
            if (i == 1) {
                fib[1] = 1 % m;
            } else if (i == 2) {
                fib[2] = 2 % m;
            } else if (fib[i] == -1) {
                fib[i] = ((fib[i - 1] % m) + (fib[i - 2] % m)) % m;
            }
        }
        System.out.println(fib[given]);
    }
}