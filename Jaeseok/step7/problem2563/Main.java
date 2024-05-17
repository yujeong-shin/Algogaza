package Jaeseok.step7.problem2563;

import java.io.*;
import java.util.*;

/**
 * 접근 방법
 *
 * 1. 정사각형 모양의 흰색 도화지를 100*100 크기의 2차원 배열 papers로 표현한다.
 * 2. 주어진 색종이의 수 N에 대해 각 색종이를 붙이는 위치를 읽으면서 해당 위치를 기준으로 10x10의 영역을 1로 업데이트한다.
 *    한 번이라도 색종이가 붙은 영역은 배열에서 1로 표시하게 된다.
 * 3. 모든 색종이를 놓은 후 도화지 전체를 검토해서 1이 표시된 위치의 개수를 카운트해서 검은 영역의 넓이를 구한다.
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int whitePaperLength = 100;
        int blackPaperLength = 10;
        int[][] papers = new int[whitePaperLength][whitePaperLength];
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());    // 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리
            int bottom = Integer.parseInt(st.nextToken());  // 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리

            // 검정 색종이의 영역을 1로 채우기
            for (int j = left; j < left + blackPaperLength; j++) {
                for (int k = bottom; k < bottom + blackPaperLength; k++) {
                    papers[j][k] = 1;
                }
            }
        }

        // 색종이가 붙은 검은 영역의 넓이 구하기
        int blackArea = 0;
        for (int[] row : papers) {
            for (int column : row) {
                if (column == 1) {
                    blackArea++;
                }
            }
        }

        // 결과 출력
        bw.write(String.valueOf(blackArea));
        bw.flush();

        br.close();
        bw.close();
    }
}
