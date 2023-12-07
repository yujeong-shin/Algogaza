import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class beak11724 {
    public static int N,M;
    static int count =0;
    public static boolean graph[][];
    public static boolean visited[];
    public static ArrayList<Integer> queue;
    public static void bfs(int start)
    {
        queue = new ArrayList<>();
        queue.add(start);
        visited[start]=true;
        while (!queue.isEmpty())
        {
            int temp = queue.remove(0);
            for (int i=1; i<=N; i++)
            {
                if (!visited[i] && graph[temp][i])
                {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }


    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
//            System.out.println(u + " " + v);
            graph[u][v] = graph[v][u] = true;

        }
//        System.out.println(Arrays.deepToString(graph));
//        System.out.println(graph.length);
        for (int i=1; i<=N; i++)
        {
            if (!visited[i])
            {
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
}
