import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_7562 {
    static int l;
    static int start_x, start_y, end_x, end_y;
    static int[][] matrix;
    static boolean[][] visited;

    static int[] dx = {1, 2, 1, 2, -2, -1, -2, -1};
    static int[] dy = {-2, -1, 2, 1, -1, -2, 1, 2};
    static int res[];
    static int ind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        res = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            start_x = Integer.parseInt(st.nextToken());
            start_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            end_x = Integer.parseInt(st.nextToken());
            end_y = Integer.parseInt(st.nextToken());

            matrix = new int[l][l];
            visited = new boolean[l][l];
            bfs(start_x, start_y);
            res[ind++] = matrix[end_x][end_y];
        }
        for (int i : res) {
            System.out.println(i);
        }
    }

    private static void bfs(int a, int b) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{a, b});
        visited[a][b] = true;
        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            for (int i = 0; i < 8; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x >= 0 && y >= 0 && x < l && y < l) {
                    if (!visited[x][y]) {
                        if (x == end_x && y == end_y) {
                            visited[x][y] = true;
                            matrix[x][y] = matrix[now[0]][now[1]] + 1;
                            break;
                        } else {
                            visited[x][y] = true;
                            matrix[x][y] = matrix[now[0]][now[1]] + 1;
                            deque.add(new int[]{x, y});
                        }
                    }
                }
            }
        }

    }
}
