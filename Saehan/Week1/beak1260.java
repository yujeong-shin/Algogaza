import  java.util.*;
import  java.io.*;

public class beak1260 {
    static boolean graph[][];
    static boolean visited[];
    static ArrayList<Integer> queue;
    static int N,M,V; //N 정점개수, M 간선개수, V 시작번호

    static void dfs(int index)
    {
        System.out.print(index + " ");
        visited[index] = true;
        for (int i=1; i<=N; i++)
        {
            if (!visited[i] && graph[index][i])
            {
                dfs(i);
            }
        }
    }
    static void bfs()
    {
        queue = new ArrayList<>();
        visited = new boolean[1000+1];
        queue.add(V);
        visited[V] = true;

        while (!queue.isEmpty())
        {
            int temp = queue.remove(0);
            System.out.print(temp + " ");
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

    public static void main(String[] args) throws  IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
//        System.out.println(N + " " + M + " " + V);
        graph = new boolean[1000+1][1000+1];
        visited = new boolean[1000+1];

        for (int i=0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(V);
        System.out.println();
        bfs();
    }
}
