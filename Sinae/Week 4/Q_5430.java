import java.io.*;
import java.util.*;

public class Q_5430 {
    static Deque<Integer> deq;
    static List<Integer> arrRes;
    static List<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcases; i++) {
            deq = new ArrayDeque<>();
            arrRes = new ArrayList<>();
//            Order of AC
            String AC = br.readLine();
//            Number of elements in an array
            int N = Integer.parseInt(br.readLine());
//            Inserting numbers to deque
            String arrayStr = br.readLine();
            arrayStr = arrayStr.replaceAll("[^\\d]", " ").trim();
            String[] splitted = arrayStr.split(" ");

            if (arrayStr.length() != 0) {
                for (String sp : splitted) {
                    deq.add(Integer.parseInt(sp));
                }
            }

            int slicedNum = 0;
            boolean inOrder = true;
            boolean err = false;
            while (slicedNum < AC.length()) {
                if (AC.charAt(slicedNum) == 'R') {
                    inOrder = !inOrder;
                } else if (AC.charAt(slicedNum) == 'D') {
                    if (inOrder) {
                        if (!deq.isEmpty()) {
                            deq.removeFirst();
                        } else {
                            bw.write("error" + "\n");
                            err = true;
                            break;
                        }
                    } else if (!inOrder) {
                        if (!deq.isEmpty()) {
                            deq.removeLast();
                        } else {
                            bw.write("error" + "\n");
                            err = true;
                            break;
                        }
                    }
                }
                slicedNum++;
            }

            if (inOrder) {
                while (!deq.isEmpty()) {
                    arrRes.add(deq.removeFirst());
                }
            } else if (!inOrder) {
                while (!deq.isEmpty()) {
                    arrRes.add(deq.removeLast());
                }
            }
            StringBuilder part = new StringBuilder();
            if (!err) {
                part.append("[");
                for (int ar : arrRes) {
                    part.append(ar);
                    part.append(",");
                }
                if (arrRes.size() != 0) {
                    part.deleteCharAt(part.length()-1);
                }
                part.append("]");
                bw.write(String.valueOf(part)+"\n");
            }
        }
        bw.flush();
    }
}