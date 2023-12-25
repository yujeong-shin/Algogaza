import java.util.*;
import java.io.*;

public class Q_10026 {
    static boolean[][] visited;
    static int[][] matrix;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static int cnt1;
    static int cnt2;
    static int cnt3;
    static int cnt4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        visited = new boolean[n][n];
        cnt1 = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == 'R') {
                    matrix[i][j] = 1;
                } else if (line.charAt(j) == 'G') {
                    matrix[i][j] = 2;
                } else if (line.charAt(j) == 'B') {
                    matrix[i][j] = -1;
                }
            }
        }

        for (int p = 0; p < n; p++) {
            for (int q = 0; q < n; q++) {
                if (!visited[p][q] && matrix[p][q] == -1) { //B
                    bfs1(p, q);
                    cnt1++;
                }
            }
        }
        reset();
        for (int p = 0; p < n; p++) {
            for (int q = 0; q < n; q++) {
                if (!visited[p][q] && matrix[p][q] > 0) { //R+G
                    bfs2(p, q);
                    cnt2++;
                }
            }
        }
        reset();
        for (int p = 0; p < n; p++) {
            for (int q = 0; q < n; q++) {
                if (!visited[p][q] && matrix[p][q] == 1) { //R
                    bfs3(p, q);
                    cnt3++;
                }
            }
        }
        reset();
        for (int p = 0; p < n; p++) {
            for (int q = 0; q < n; q++) {
                if (!visited[p][q] && matrix[p][q] == 2) { //G
                    bfs4(p, q);
                    cnt4++;
                }
            }
        }
        System.out.print((cnt3 + cnt4 + cnt1) + " " + (cnt1 + cnt2));
    }

    private static void reset() {

        for (int p = 0; p < n; p++) {
            for (int q = 0; q < n; q++) {
                visited[p][q] = false;
            }
        }
    }

    private static void bfs1(int a, int b) {
        Deque<int[]> deque = new ArrayDeque<>();
        visited[a][b] = true;
        deque.add(new int[]{a, b});
        while (!deque.isEmpty()) {
            int[] d = deque.removeFirst();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + d[0];
                int y = dy[i] + d[1];
                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (!visited[x][y] && matrix[x][y] == -1) {
                        visited[x][y] = true;
                        deque.add(new int[]{x, y});
                    }
                }
            }
        }
    }

    private static void bfs2(int a, int b) {
        Deque<int[]> deque = new ArrayDeque<>();
        visited[a][b] = true;
        deque.add(new int[]{a, b});
        while (!deque.isEmpty()) {
            int[] d = deque.removeFirst();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + d[0];
                int y = dy[i] + d[1];
                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (!visited[x][y] && matrix[x][y] > 0) {
                        visited[x][y] = true;
                        deque.add(new int[]{x, y});
                    }
                }
            }
        }
    }

    private static void bfs3(int a, int b) {
        Deque<int[]> deque = new ArrayDeque<>();
        visited[a][b] = true;
        deque.add(new int[]{a, b});
        while (!deque.isEmpty()) {
            int[] d = deque.removeFirst();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + d[0];
                int y = dy[i] + d[1];
                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (!visited[x][y] && matrix[x][y] == 1) {
                        visited[x][y] = true;
                        deque.add(new int[]{x, y});
                    }
                }
            }
        }
    }

    private static void bfs4(int a, int b) {
        Deque<int[]> deque = new ArrayDeque<>();
        visited[a][b] = true;
        deque.add(new int[]{a, b});
        while (!deque.isEmpty()) {
            int[] d = deque.removeFirst();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + d[0];
                int y = dy[i] + d[1];
                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (!visited[x][y] && matrix[x][y] == 2) {
                        visited[x][y] = true;
                        deque.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
