import java.io.*;
import java.util.*;

public class Q_16234 {
    static int[][] matrix;

    static int N, R, L;
    static int[] dx = {0, 0, -1, 1}; //top, bottom, left, right
    static int[] dy = {-1, 1, 0, 0}; //top, bottom, left, right
    static boolean[][] visited;
    static List<int[]> list;
    static List<int[]> total;

    static boolean b = true;
    static int sum = 0;

    static int count = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        matrix = new int[N][N];
        visited = new boolean[N][N];
        list = new ArrayList<>();
        total = new ArrayList<>();

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int nn = 0; nn < N; nn++) {
                matrix[n][nn] = Integer.parseInt(st.nextToken());
            }
        }

        while (b) {
            b = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sum = 0;
                    if (!visited[i][j]) {
                        removeBorder(i, j);
                        total = new ArrayList<>();
                        for (int[] a : list) {
                            total.add(a);
                        }
                        if (total.size() > 1) { //bfs가 만들어졌을 때
                            updateAvg(sum / total.size());
                            b = true;
                        }
                    }
                }
            }
            if (!b) {
                System.out.println(count);
                return;
            }
            count++;
            visited = new boolean[N][N];
        }


    }


    static void updateAvg(int avg) {
        for (int[] a : total) {
            matrix[a[0]][a[1]] = avg;
        }
    }

    static void removeBorder(int i, int j) {
        sum = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        list = new ArrayList<>();
        deque.add(new int[]{i, j});
        list.add(new int[]{i, j});
        sum += matrix[i][j];
        visited[i][j] = true;
        while (!deque.isEmpty()) {
            int[] polled = deque.removeFirst();
            for (int d = 0; d < 4; d++) {
                int x = polled[0] + dx[d];
                int y = polled[1] + dy[d];
                if (x >= 0 && y >= 0 && x < N && y < N) {
                    if (!visited[x][y] && (Math.abs(matrix[x][y] - matrix[polled[0]][polled[1]]) >= L)
                            && (Math.abs(matrix[x][y] - matrix[polled[0]][polled[1]]) <= R)) {
                        deque.add(new int[]{x, y});
                        list.add(new int[]{x, y});
                        sum += matrix[x][y];
                        visited[x][y] = true;
                    }
                }
            }
        }

    }

}
