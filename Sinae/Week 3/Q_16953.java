import java.io.*;
import java.util.*;

public class Q_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int count = 0;
        Deque<Long> deque = new ArrayDeque<>();
        deque.add(a * 2);
        deque.add(a * 10 + 1);
        while (!deque.isEmpty()) {
            count++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Long p = deque.removeFirst();
                if (p > b) {
                    System.out.println(p);
                    continue;
                } else if (p == b) {
                    System.out.println(count + 1);
                    return;
                }

                deque.add(p * 2);
                deque.add(p * 10 + 1);
            }
        }
        System.out.println(-1);
    }
}

//import java.io.*;
//        import java.util.*;
//
//public class Q_16953 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        long a = Long.parseLong(st.nextToken());
//        long b = Long.parseLong(st.nextToken());
//        int count = 1;
//        long temp = b;
//        while (a < temp) {
//            String str = String.valueOf(temp);
//            if (temp % 2 == 0) {
//                temp /= 2;
//                count++;
//            } else if (str.substring(str.length() - 1, str.length()).equals("1")) {
//                temp = Long.parseLong(str.substring(0, str.length() - 1));
//                count++;
//            } else {
//                break;
//            }
//        }
//        if (a != temp) {
//            count = -1;
//        }
//        System.out.println(count);
//    }
//}