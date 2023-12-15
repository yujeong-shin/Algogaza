import java.io.*;
import java.util.*;

public class beak16953 {
    static int a, b, acc;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        acc=1;
        while (b!=a)
        {
            acc++;
            int check = b;

            if (b%10 == 1)
                b = b/10;
            else if (b%2 == 0)
                b/=2;

            if (check==b)
            {
                System.out.print("-1");
                return;
            }
        }
        System.out.print(acc);
    }
}