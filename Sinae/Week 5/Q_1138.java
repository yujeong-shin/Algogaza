import java.io.*;
import java.util.*;

public class Q_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> given = new ArrayList<>();
        List<Integer> order = new ArrayList<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            given.add(Integer.parseInt(st.nextToken()));
        }
        for (int j = given.size() - 1; j >= 0; j--) {
            if (order.isEmpty()) order.add(j + 1);
            else {
                order.add(given.get(j), j + 1);
            }
        }
        for (int o = 0; o < order.size() - 1; o++) {
            bw.write(order.get(o) + " ");
        }
        bw.write(order.get(order.size() - 1) + "\n");
        bw.flush();
        bw.close();
    }
}
