import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class beak1012 {
    static boolean graph[][];
    static boolean visited[][];
    static int T, M, N, K, count;

    static void dfs(int x, int y) {
        if (x < 1 || y < 1 || x > M || y > N || visited[y][x] || !graph[y][x])
            return;

        visited[y][x] = true;

        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로

            graph = new boolean[N + 1][M + 1];
            visited = new boolean[N + 1][M + 1];
            count = 0;

            K = Integer.parseInt(st.nextToken()); // 배추 수
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[y + 1][x + 1] = true;
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (!visited[i][j] && graph[i][j]) {
                        dfs(j, i);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
