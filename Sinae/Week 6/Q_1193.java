import java.util.Scanner;

public class Q_1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = Integer.parseInt(sc.next());
        int i = 1;
        int count = 0;
        int row = 0;
        int col = 0;
        int after = s;
        while (true) {
            if (after - i >= 0) {
                after -= i;
                count++;
                i++;
            } else {
                if (count % 2 == 0) {
                    row = count - after + 2;
                    col = after;
                    if (col == 0) {
                        col = 1;
                        row = count;
                    }
                }
                if (count % 2 == 1) {
                    col = count - after + 2;
                    row = after;
                    if (row == 0) {
                        row = 1;
                        col = count;
                    }
                }
                System.out.printf("%d/%d", row, col);
                break;
            }
        }
    }
}