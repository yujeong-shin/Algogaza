import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class Q_11724 {
    static ArrayList<Integer>[] l;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //num of nodes
        int m = Integer.parseInt(st.nextToken()); //num of edges
        l = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        //creating arraylist in the arraylist
        for (int i = 1; i < n + 1; i++) {
            l[i] = new ArrayList<Integer>();
        }

        //adding edges to the arraylist
        for (int j = 0; j < m; j++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st2.nextToken()); //starting node (edge-wise)
            int e = Integer.parseInt(st2.nextToken()); //ending node (edge-wise)
            l[s].add(e);
            l[e].add(s);
        }

        int count = 0;
        for (int k = 1; k < n + 1; k++) {
            if (!visited[k]) {
                count++;
                dfs(k);
            }
        }
        System.out.println(count);
    }

    public static void dfs(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;

        for (int n : l[v]) {
            if (!visited[n]) {
                dfs(n);
            }
        }
    }
}