import java.util.*;

public class Q_4673 {
    static List<Integer> l = new ArrayList<>();

    public static void main(String[] args) {
        int num = 0;
        for (int i = 1; i <= 10000; i++) {
            l.add(helper(i));
        }

        for (int j = 1; j <= 10000; j++) {
            if (!l.contains(j)) {
                System.out.println(j);
            }
        }

    }

    public static int helper(int num) {
        int sub = 0;
        for (int i = 0; i < String.valueOf(num).length(); i++) {
            sub += Integer.parseInt(String.valueOf(num).substring(i, i + 1));
        }
        sub += num;
        return sub;
    }

}

