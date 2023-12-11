import java.io.*;
import java.util.*;

public class beak7562 {
    static int T,m;
    static boolean graph[][];
    static Queue<Pos> queue;
    static int dx[] = {-1,-2,-2,-1,1,2,2,1};
    static int dy[] = {-2,-1,1,2,2,1,-1,-2};
    static StringBuilder sb = new StringBuilder();
    static class Pos
    {
        int x,y,moveCount;
        public Pos(int x, int y, int moveCount)
        {
            this.x = x;
            this.y = y;
            this.moveCount = moveCount;
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while (T-- > 0)
        {
            m = sc.nextInt();

            int x = sc.nextInt();
            int y = sc.nextInt();
            Pos currentPos = new Pos(x,y,0);

            x = sc.nextInt();
            y = sc.nextInt();
            Pos idealPos = new Pos(x,y,0);

            graph = new boolean[m][m];
            bfs(currentPos, idealPos);
        }
        System.out.println(sb.toString());
    }

    static void bfs(Pos cp, Pos ip)
    {
        queue = new LinkedList<>();
        queue.offer(cp);
        graph[cp.x][cp.y] = true;

        while (!queue.isEmpty())
        {
            Pos temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            int moveCount = temp.moveCount;

            if (x == ip.x && y == ip.y)
            {
                sb.append(moveCount).append("\n");
                return;
            }

            for (int i=0; i < dx.length; i++)
            {
                int n_x = x + dx[i];
                int n_y = y + dy[i];

                if (n_x >=0 && n_y>=0 && n_x <m && n_y <m && !graph[n_x][n_y])
                {
                    graph[n_x][n_y] = true;
                    queue.offer(new Pos(n_x, n_y, moveCount + 1));
                }
            }
        }
    }
}