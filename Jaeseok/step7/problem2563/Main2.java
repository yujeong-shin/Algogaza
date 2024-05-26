package Jaeseok.step7.problem2563;

import java.io.*;
import java.util.*;

/**
 * 접근 방법(Main과 달리 불필요한 과정은 제거)
 *
 * 1. 정사각형 모양의 흰색 도화지를 100*100 크기의 2차원 배열 papers로 표현한다.
 * 2. 주어진 색종이의 수 N에 대해 각 색종이를 붙이는 위치를 읽으면서 해당 위치를 기준으로 10x10의 영역을 1로 업데이트한다.
 *    한 번이라도 색종이가 붙은 영역은 배열에서 1로 표시하게 된다.
 * 3. 1로 표시하면서 검정색 영역을 카운트하고, 카운트한 값을 리턴한다.
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int whitePaperLength = 100;
        int blackPaperLength = 10;
        int[][] papers = new int[whitePaperLength][whitePaperLength];
        int blackArea = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());    // 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리
            int bottom = Integer.parseInt(st.nextToken());  // 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리

            // 검정 색종이의 영역을 1로 채우기
            for (int j = left; j < left + blackPaperLength; j++) {
                for (int k = bottom; k < bottom + blackPaperLength; k++) {
                    if (papers[j][k] == 0) {
                        papers[j][k] = 1;
                        blackArea++;
                    }
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
