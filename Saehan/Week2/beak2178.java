import java.io.*;
import java.util.*;

public class beak2178 {
    static int N,M,count;
    static boolean graph[][];
    static Queue<Pos> queue;
    static int dx[]={-1,1,0,0};
    static int dy[]={0,0,-1,1};
    static class Pos
    {
        int x,y;
        Pos(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[]=br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        graph = new boolean[N+1][M+1];

        for (int i=1; i<=N; i++)
        {
            String str = br.readLine();
            for (int j=1; j<=M; j++)
                graph[i][j] = str.charAt(j-1) == '1';
        }
//        System.out.println(Arrays.deepToString(graph));

        for (int i=1; i<=N; i++)
        {
            for (int j=1; j<=M; j++)
            {
                if (graph[i][j])
                {
                    bfs(new Pos(i,j), new Pos(N,M));
                    System.out.println(count);
                    return;
                }
            }
        }
        System.out.println(count);
    }

    static void bfs(Pos cp, Pos ip) {
        boolean[][] visited = new boolean[N + 1][M + 1];
        queue = new LinkedList<>();
        queue.offer(cp);
        visited[cp.x][cp.y] = true;
        count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Pos temp = queue.poll();

                if (temp.x == ip.x && temp.y == ip.y) {
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int n_x = temp.x + dx[i];
                    int n_y = temp.y + dy[i];

                    if (n_x >= 1 && n_y >= 1 && n_x <= N && n_y <= M && !visited[n_x][n_y] && graph[n_x][n_y]) {
                        queue.offer(new Pos(n_x, n_y));
                        visited[n_x][n_y] = true;
                    }
                }
            }
            count++;
        }
    }
}
