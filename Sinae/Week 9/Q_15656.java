import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q_15656 {
    static int N;
    static int M;
    static BufferedWriter bw;
    static List<Integer> l;
    static List<Integer> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String line = br.readLine();
        st = new StringTokenizer(line);
        list = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        visited = new boolean[N];
        l = new ArrayList<>();
        dfs(visited, l);
        bw.flush();
    }

    static void dfs(boolean[] visited, List<Integer> l) throws IOException {
        if (l.size() == M) {
            for (int i = 0; i < M; i++) {
                bw.write(l.get(i) + " ");
            }
            bw.write("\n");
        } else {
            for (int i = 0; i < list.size(); i++) {
                l.add(list.get(i));
                dfs(visited, l);
                l.remove(l.size() - 1);
            }
        }
    }
}
