import  java.util.*;
import  java.io.*;

public class beak2606 {

    static boolean[] visited = new boolean[101];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int A,B,C;

    static void dfs(int start)
    {
        visited[start] = true;
        for (int i : graph.get(start))
        {
            if (!visited[i])
            {
                visited[i]=true;
                dfs(i);
                C++;
            }
        }
    };

    public static void main(String[] args) throws  IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());

        for (int i=0; i <= A; i++)
            graph.add(new ArrayList<>());

        for (int i=0; i <B; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        //System.out.println(graph);
        //System.out.println(visited[0]);

        dfs(1);
        System.out.println(C);
    }
}
