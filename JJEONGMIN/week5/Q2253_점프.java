import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q2253_점프 {
    static int N, M;
    static int[][] stones;
    static List<Integer> smallList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        double k = (-1 + Math.sqrt(1 + 8 * (N + 2))) / 2;
        int maxJump = (int) k + 1;
        stones = new int[N + 1][maxJump + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            smallList.add(a);
        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(stones[i], Integer.MAX_VALUE);
        }

        stones[1][0] = 0;

        for (int i = 1; i <= N; i++) {
            if (smallList.contains(i)) continue;

            for (int j = 1; j <= maxJump; j++) {
                if (i - j > 0 && stones[i - j][j - 1] != Integer.MAX_VALUE) {
                    stones[i][j] = Math.min(stones[i][j], stones[i - j][j - 1] + 1);
                }
                if (i - j > 0 && stones[i - j][j] != Integer.MAX_VALUE) {
                    stones[i][j] = Math.min(stones[i][j], stones[i - j][j] + 1);
                }
                if (i - j > 0 && j + 1 <= maxJump && stones[i - j][j + 1] != Integer.MAX_VALUE) {
                    stones[i][j] = Math.min(stones[i][j], stones[i - j][j + 1] + 1);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 1; j <= maxJump; j++) {
            result = Math.min(result, stones[N][j]);
        }

        if (result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }
}