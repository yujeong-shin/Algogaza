package Jaeseok.step7.problem2566;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int maxValue = -1;  // 0으로 설정하지 않도록 주의!
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value > maxValue) {
                    maxValue = value;
                    // 주어진 격자판은 0이 아닌 1부터 시작하기 때문에 +1을 수행.
                    maxRow = i + 1;
                    maxCol = j + 1;
                }
            }
        }

        bw.write(String.valueOf(maxValue));
        bw.newLine();
        bw.write(maxRow + " " + maxCol);
        bw.flush();

        br.close();
        bw.close();
    }
}
