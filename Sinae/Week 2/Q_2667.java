import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_2667 {
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static int count;
    static List<Integer> l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        matrix = new int[n][n];
        visited = new boolean[n][n];
        l = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && matrix[i][j] != 0) {
                    bfs(i, j);
                }
            }
        }

        Collections.sort(l);
        System.out.println(l.size());
        for (Integer ll : l) {
            System.out.println(ll.intValue());
        }
    }

    private static void bfs(int a, int b) {
        Deque<int[]> deque = new ArrayDeque<>();
        visited[a][b] = true;
        deque.add(new int[]{a, b});
        count = 1;
        while (!deque.isEmpty()) {
            int now[] = deque.removeFirst();
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x >= 0 && y >= 0 && x < n && y < n)
                    if (!visited[x][y] && matrix[x][y] != 0) {
                        count++;
                        visited[x][y] = true;
                        deque.add(new int[]{x, y});
                    }
            }
        }
        l.add(count);
    }
}
