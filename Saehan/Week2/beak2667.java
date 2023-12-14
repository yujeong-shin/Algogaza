import java.io.*;
import java.util.*;

public class beak2667 {
    static int N,count;
    static boolean graph[][];
    static int dx[]={-1,1,0,0};
    static int dy[]={0,0,-1,1};
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new boolean[N+1][N+1];

        for (int i = 1; i <=N; i++)
        {
            String s = br.readLine();
//            System.out.println(s);
            for (int j=1; j <=N; j++)
                graph[i][j] = s.charAt(j-1) == '1';
        }
//        System.out.println(Arrays.deepToString(graph));
        for (int i = 1; i <=N; i++)
        {
            for (int j=1; j <= N; j++)
            {
                if (graph[i][j])
                {
                    count = 0;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (Integer v : result) {
            System.out.print(v + "\n");
        }
    }
    static void dfs(int i, int j)
    {
//        if (i < 1 || j < 1 || i > N || j > N || !graph[i][j])
//            return;

        graph[i][j] = false;
        count++;
        for (int k =0; k < 4; k++)
        {
            int n_x = i + dx[k];
            int n_y = j + dy[k];

            if (n_x>=1 && n_y >=1 && n_x <= N && n_y <= N && graph[n_x][n_y])
                dfs(n_x,n_y);
        }
    }
}
