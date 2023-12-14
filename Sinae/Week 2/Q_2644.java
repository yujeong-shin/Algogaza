import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_2644 {
    static ArrayList<Integer>[] l;
    static boolean[] visited;
    static int count = 0;
    static boolean rb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        First input line
        int node_num = Integer.parseInt(br.readLine());
//        Second input line
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target_s = Integer.parseInt(st.nextToken());
        int target_e = Integer.parseInt(st.nextToken());
//        Third input line
        st = new StringTokenizer(br.readLine());
        int edge_num = Integer.parseInt(st.nextToken());

//        Creating arraylist in the array
        l = new ArrayList[node_num + 1];
        visited = new boolean[node_num + 1];

        for (int i = 1; i < node_num + 1; i++) {
            l[i] = new ArrayList<Integer>();
        }

//         From fourth: input edges
        for (int i = 0; i < edge_num; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            l[s].add(e);
            l[e].add(s);
        }
        dfs(target_s, target_e, 0);
        if (!rb) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

    static void dfs(int a, int b, int c) {
        if (visited[a]) {
            return;
        }
        visited[a] = true;
        for (int ll : l[a]) {
            if (!visited[ll]) {
                if (b == ll) {
                    count = c + 1;
                    rb = true;
                    return;
                }
                dfs(ll, b, c + 1);
            }
        }

    }
}
