import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q_10974 {
    static int N;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.next());
        //? 머해 시내야
        List<Integer> l = new ArrayList<>();
        boolean[] visited = new boolean[N+1];
        dfs(l, visited);
        bw.flush();
        bw.close();
    }

    static void dfs(List<Integer> l, boolean[] visited) throws IOException {
        if (l.size() == N) {
            for (int ll = 0; ll < l.size(); ll++) {
                bw.write(l.get(ll) + " ");
            }
            bw.write("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    l.add(i);
                    dfs(l, visited);
                    l.remove(l.size() - 1);
                    visited[i]=false;
                }
            }
        }
    }
}
