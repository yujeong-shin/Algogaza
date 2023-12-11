import java.io.*;
import java.util.*;

public class beak11725 {
    static int N, prev;
    static int parent[];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        Arrays.fill(parent, -1);

        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }
//        System.out.println(graph);
        dfs(1,-1);

        for (int i = 2; i <= N; i++)
        {
            int prev_n = parent[i];
            if (prev_n != -1)
            {
                System.out.println(prev_n);
            }
        }
    }

    static void dfs(int start, int prev)
    {
        parent[start] = prev;
        for (int n : graph.get(start))
        {
            if (n != prev)
                dfs(n, start);
        }
    }
}