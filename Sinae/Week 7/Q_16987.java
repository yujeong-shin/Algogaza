import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_16987 {
    static int N;
    static int answer = -1;
    static int[][] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new int[N][2];
        int index = 0;
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[index++] = new int[]{d, w};
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int holding, int cracked) {
        if (holding == N) {
            if (answer < cracked) {
                answer = cracked;
            }
            return;
        }
        if (eggs[holding][0] <= 0 || cracked == N - 1) {
            dfs(holding + 1, cracked);
            return;
        }
        int c = cracked;
        for (int i = 0; i < N; i++) {
            if (i == holding) continue;
            if (eggs[i][0] <= 0) continue;
            tapEgg(holding, i);
            if (eggs[holding][0] <= 0) {
                cracked++;
            }
            if (eggs[i][0] <= 0) {
                cracked++;
            }
            dfs(holding + 1, cracked);
            back(holding, i);
            cracked = c;
        }
    }

    static void tapEgg(int hitter, int hitted) {
        eggs[hitter][0] -= eggs[hitted][1];
        eggs[hitted][0] -= eggs[hitter][1];
    }

    static void back(int hitter, int hitted) {
        eggs[hitter][0] += eggs[hitted][1];
        eggs[hitted][0] += eggs[hitter][1];
    }
}