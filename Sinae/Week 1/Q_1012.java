import java.io.*;
import java.util.*;

public class Q_1012 {
    static int[][] matrix;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int column;
    static int row;
    static int cabbages;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            column = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            cabbages = Integer.parseInt(st.nextToken());
            matrix = new int[column][row];
            visited = new boolean[column][row];
            count = 0;
            for (int j = 0; j < cabbages; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                matrix[x][y] = 1;
            }
            for (int jj = 0; jj < column; jj++) {
                for (int kk = 0; kk < row; kk++) {
                    if (matrix[jj][kk] == 1 && !visited[jj][kk]) {
                        count++;
                        bfs(jj, kk);
                    }
                }
            }
            l.add(count);
        }
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }
    private static void bfs(int a, int b) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{a, b});
        visited[a][b] = true;
        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x >= 0 && y >= 0 && x < column && y < row) {
                    if (!visited[x][y] && matrix[x][y] == 1) {
                        visited[x][y] = true;
                        deque.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
