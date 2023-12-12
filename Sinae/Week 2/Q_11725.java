import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_11725 {
    public static ArrayList<Integer>[] l;
    public static boolean[] visited;
    public static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());

        l = new ArrayList[node + 1];
        visited = new boolean[node + 1];

        for (int i = 1; i < node + 1; i++) {
            l[i] = new ArrayList<>();
        }

        for (int i = 1; i < node - 1 + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            l[s].add(e);
            l[e].add(s);
        }
        res = new int[node + 1];
        dfs(1);
        for (int i = 2; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }

    static int chk = 0;

    private static void dfs(int a) {
        if (visited[a]) {
            return;
        }
        visited[a] = true;
        for (int ll : l[a]) {
            if (!visited[ll]) {
                res[ll] = a;
                dfs(ll);
            }
        }
    }
}