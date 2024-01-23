import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

class Q_15651 {
    static int N;
    static int M;
    static BufferedWriter bw;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<Integer> l = new ArrayList<>();
        list = new ArrayList<>();
        dfs(l);
        bw.flush();
        bw.close();
    }

    static void dfs(List<Integer> l) throws IOException {
        if (l.size() == M) {
            list.add(new ArrayList<>(l));
            for (int i = 0; i < l.size(); i++) {
                bw.write(l.get(i) + " ");
            }
            bw.write("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                l.add(i);
                dfs(l);
                l.remove(l.size() - 1);
            }
        }
    }
}
