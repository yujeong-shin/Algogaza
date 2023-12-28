import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q10026_적록색약 {
    static class Node {
        int h;
        int w;
        char type;

        public Node(int h, int w, char type) {
            this.h = h;
            this.w = w;
            this.type = type;
        }
    }

    static int N, count = 0;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        result.append(count);
        result.append(" ");
        count = 0;
        for (int i = 0; i < N; i++)
            Arrays.fill(visited[i], false);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                if (map[i][j] == 'G') map[i][j] = 'R';
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        result.append(count);
        System.out.println(result);
    }

    private static void bfs(int start_h, int start_w) {
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};

        Queue queue = new LinkedList<Integer>();

        queue.offer(new Node(start_h, start_w, map[start_h][start_w]));
        visited[start_h][start_w] = true;

        while (!queue.isEmpty()) {
            int next_h = 0;
            int next_w = 0;
            Node now = (Node) queue.poll();

            for (int i = 0; i < 4; i++) {
                next_h = now.h + dy[i];
                next_w = now.w + dx[i];

                if (next_h < 0 || next_h >= N || next_w < 0 || next_w >= N) continue;

                if (map[next_h][next_w] == now.type && !visited[next_h][next_w]) {
                    visited[next_h][next_w] = true;
                    queue.offer(new Node(next_h, next_w, now.type));
                }
            }
        }
    }
}