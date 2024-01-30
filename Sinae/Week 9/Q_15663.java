import java.io.*;
import java.util.*;

public class Q_15663 {
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
        boolean[] repeatedChk = new boolean[10001];
        l = new ArrayList<>();
        dfs(l, visited, repeatedChk);
        bw.flush();
    }

    static void dfs(List<Integer> l, boolean[] visited, boolean[] repeatedChk) throws IOException {
        if (l.size() == M) {
            for (int i = 0; i < M; i++) {
                bw.write(l.get(i) + " ");
            }
            bw.write("\n");

        } else {
            repeatedChk = new boolean[10001];
            for (int i = 0; i < list.size(); i++) {
                if (!visited[i] && !repeatedChk[list.get(i)]) {
                    visited[i] = true;
                    repeatedChk[list.get(i)] = true;
                    l.add(list.get(i));
                    dfs(l, visited, repeatedChk);
                    l.remove(l.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
}
