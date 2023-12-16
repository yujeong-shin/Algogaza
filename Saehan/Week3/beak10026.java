import java.util.Scanner;

public class beak10026
{
    static int N, r, g, b, rg;
    static boolean visited[][];
    static char graph[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        graph = new char[N][N];

        for(int i = 0; i < N; i++)
        {
            String s = sc.nextLine();
            for(int j = 0; j < N; j++)
                graph[i][j] = s.charAt(j);
        }
        //System.out.println(Arrays.deepToString(graph));
        visited = new boolean[N][N];
        r = g = b = 0;
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(!visited[i][j] && graph[i][j] == 'R')
                {
                    r++;
                    dfs(i, j, 'R');
                } else if(!visited[i][j] && graph[i][j] == 'B')
                {
                    b++;
                    dfs(i, j, 'B');
                } else if(!visited[i][j] && graph[i][j] == 'G')
                {
                    g++;
                    dfs(i, j, 'G');
                }
            }
        }

        visited = new boolean[N][N];
        rg = 0;
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(!visited[i][j] && (graph[i][j] == 'R' || graph[i][j] == 'G'))
                {
                    rg++;
                    dfs(i, j, 'X');
                } else if(!visited[i][j] && graph[i][j] == 'B')
                    dfs(i, j, 'B');
            }
        }

        System.out.println((r + g + b) + " " + (rg + b));
    }

    static void dfs(int x, int y, char c)
    {
        visited[x][y] = true;

        for(int i = 0; i < dx.length; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny])
            {
                if(c == 'X' && (graph[nx][ny] == 'R' || graph[nx][ny] == 'G'))
                    dfs(nx, ny, c);
                else if(graph[nx][ny] == c)
                    dfs(nx, ny, c);
            }
        }
    }
}
