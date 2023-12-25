import java.util.*;

public class beak2636
{
    static int W, H, acc, left;
    static int graph[][];
    static boolean visited[][];

    static class Node
    {
        int x;
        int y;

        Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    static List<Node> check;

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        W = sc.nextInt();
        H = sc.nextInt();
        sc.nextLine();
        graph = new int[W][H];
        check = new ArrayList<>();

        for(int i = 0; i < W; i++)
        {
            String s = sc.nextLine();
            StringTokenizer st = new StringTokenizer(s);
            for(int j = 0; j < H; j++)
            {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        System.out.println(Arrays.deepToString(graph));

        while(true)
        {
            left = 0;
            visited = new boolean[W][H];
            check.clear();

            dfs(0,0);

//            for(int i = 0; i < W; i++)
//            {
//                for(int j = 0; j < H; j++)
//                {
//                    if(!visited[i][j] && graph[i][j] == 0)
//                    {
//                        dfs(i, j);
//                    }
//                }
//            }

            //check에 있는 값들 graph에서 날리기
            for(Node n : check)
            {
                left++; // 전부 0으로 바뀌기 직전값 저장용
                graph[n.x][n.y] = 0;
            }

            boolean flag = false; //graph에 0 있나 없나
            for(int i=0; i<W; i++)
            {
                for(int j=0; j<H; j++)
                {
                    if(graph[i][j] == 1)
                        flag = true;
                }
            }

            acc++; // dfs count
            if(!flag) break;
        }
//        for (Node node : check) {
//            System.out.println("(" + node.x + ", " + node.y + ")");
//        }
        System.out.println(acc);
        System.out.println(left);
    }

    static void dfs(int x, int y)
    {
        visited[x][y] = true;

        if(graph[x][y] == 1)
        {
            check.add(new Node(x, y));
            return;
        }

        for(int i = 0; i < dx.length; i++)
        {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx >= 0 && nx < W && ny >= 0 && ny < H && !visited[nx][ny])
            {
                dfs(nx, ny);
            }
        }
    }
}
