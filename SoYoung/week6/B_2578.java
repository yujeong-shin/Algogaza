// 빙고

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2578 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[5][5];
        List<Integer> list = new ArrayList<>();
        int bingo = 0;

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

        outerLoop:
        for(int i=0; i<list.size(); i++) {
            int a = list.get(i);
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    if (arr[x][y] == a) {
                        arr[x][y] = 0;
                    }
                }
            }
            if(i>=4) {
                for (int x = 0; x < 5; x++) { // 행
                    int count = 0;
                    for (int y = 0; y < 5; y++) {
                        if (arr[x][y] == 0) {
                            count++;
                        }
                    }
                    if (count == 5) {
                        bingo++;
                    }
                }
                for (int x = 0; x < 5; x++) { // 열
                    int count = 0;
                    for (int y = 0; y < 5; y++) {
                        if (arr[y][x] == 0) {
                            count++;
                        }
                    }
                    if (count == 5) {
                        bingo++;
                    }
                }
                int count = 0;
                for (int x = 0; x < 5; x++) {
                    if (arr[x][x] == 0) {
                        count++;
                    }
                }
                if (count == 5) {
                    bingo++;
                }
                count = 0;
                for (int x = 0; x < 5; x++) {
                    if (arr[x][4 - x] == 0) {
                        count++;
                    }
                }
                if (count == 5) {
                    bingo++;
                }

                if (bingo >= 3) {
                    System.out.println(i+1);
                    break outerLoop;
                }
                bingo = 0;
            }
        }
    }
}
