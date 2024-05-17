package Jaeseok.step7.problem2738;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String line;
        int[][] arrayA = new int[N][M];
        int[][] arrayB = new int[N][M];

        // 행렬 A 채우기
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            for (int j = 0; j < M; j++) {
                arrayA[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행렬 B 채우기
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            for (int j = 0; j < M; j++) {
                arrayB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 두 행렬을 더한 결과를 출력
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                sb.append(arrayA[i][j] + arrayB[i][j]).append(" ");
            }
            bw.write(sb.toString().trim());
            bw.newLine();
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
