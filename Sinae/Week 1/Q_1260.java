import java.util.*;
import java.io.*;

public class Q_1260 {

    static List<Integer>[] array;
    static boolean[] visited_dfs;
    static boolean[] visited_bfs;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodes = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        int start_node = Integer.parseInt(st.nextToken());

        array = new ArrayList[nodes + 1];
        visited_dfs = new boolean[nodes + 1];
        visited_bfs = new boolean[nodes + 1];

        for (int i = 1; i < nodes + 1; i++) {
            array[i] = new ArrayList<>();
        }

        for (int j = 1; j < edges + 1; j++) { //building up array
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            array[s].add(e);
            array[e].add(s);
        }

        for (int i = 1; i < nodes + 1; i++) {
            Collections.sort(array[i]);
        }
        dfs(start_node);
        System.out.println();
        bfs(start_node);
    }

    private static void dfs(int a) {
        Stack<Integer> stack = new Stack<>();
        System.out.print(a + " ");
        if (visited_dfs[a]) {
            return;
        }
        visited_dfs[a] = true;
        for (int aa : array[a]) {
            if (!visited_dfs[aa]) {
                dfs(aa);
            }
        }

    }

    private static void bfs(int a) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        visited_bfs[a] = true;
        deque.add(a);
        while (!deque.isEmpty()) {
            int d = deque.removeFirst();
            System.out.print(d + " ");
            for (int aa : array[d]) {
                if (!visited_bfs[aa]) {
                    visited_bfs[aa] = true;
                    deque.add(aa);
                }
            }
        }
    }
}
