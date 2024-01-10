import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

import static java.lang.System.exit;

public class ex2578_빙고 {
    static int[][] bingo;
    static int count ;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        bingo = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 5; j++) {
                int target = Integer.parseInt(stk.nextToken());
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (bingo[k][l] == target) {
                            bingo[k][l] = 0;
                        }
                    }
                }
                rCheck();
                cCheck();
                lDownCheck();
                rDownCheck();
                if (count >= 3) { // 3줄 이상 빙고이면 몇 번째 숫자인지 출력하고 종료
                    System.out.println(i*5 + j + 1);
                    exit(0);
                }
                count = 0;
            }
        }
    }


    //가로 체크
    public static void rCheck() {
        for (int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == 0)
                    zeroCount++;
            }
            if (zeroCount == 5)
                count++;
        }
    }

    // 세로 체크
    public static void cCheck() {
        for (int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] == 0)
                    zeroCount++;
            }
            if (zeroCount == 5)
                count++;
        }
    }

    // 우 하향대각선
    public static void lDownCheck() {
        int zeroCount = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == 0)
                zeroCount++;
        }
        if (zeroCount == 5)
            count++;
    }

    // 우상향대각선
    public static void rDownCheck() {
        int zeroCount = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][4 - i] == 0)
                zeroCount++;
        }
        if (zeroCount == 5)
            count++;
    }
}
