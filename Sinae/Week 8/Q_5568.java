import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_5568 {
    static List<Integer> given;
    static int N;
    static int K;
    static Set<String> totalSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        given = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            given.add(Integer.parseInt(br.readLine()));
        }
        List<Integer> l = new ArrayList<>();
        boolean[] visited = new boolean[N];
        dfs(l, visited);
        System.out.println(totalSet.size());
    }

    static void dfs(List<Integer> l, boolean[] visited) {
        if (l.size() == K) {
            String s = "";
            for (int ll : l) {
                s += String.valueOf(ll);
            }
            totalSet.add(s);
        } else {
            for (int i = 0; i < given.size(); i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    l.add(given.get(i));
                    dfs(l,visited);
                    l.remove(l.size() - 1);
                    visited[i] = false;

                }

            }
        }
    }
}
