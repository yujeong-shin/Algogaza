import java.io.*;
import java.util.*;

public class beak4963 {
    static Queue<Node> queue;
    static int W, H, count, n_x, n_y;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static void bfs(int x, int y) {
        queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (int i = 0; i < 8; i++) {
                n_x = dx[i] + temp.x;
                n_y = dy[i] + temp.y;

                if (n_x >= 1 && n_y >= 1 && n_x <= H && n_y <= W) {
                    if (!visited[n_x][n_y] && graph[n_x][n_y] == 1) {
                        visited[n_x][n_y] = true;
                        queue.offer(new Node(n_x, n_y));
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String check = "";
        while (!(check = bf.readLine()).equals("0 0")) {
            st = new StringTokenizer(check);

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            
            graph = new int[H + 1][W + 1];
            visited = new boolean[H + 1][W + 1];
            count = 0;

            for (int i = 1; i <= H; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 1; j <= W; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    graph[i][j] = num;
//                        System.out.println(Integer.parseInt(st2.nextToken()));
                }
            }
//                System.out.println(Arrays.deepToString(graph));

            for (int i = 1; i <= H; i++) {
                for (int j = 1; j <= W; j++) {
                    if (!visited[i][j] && graph[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}