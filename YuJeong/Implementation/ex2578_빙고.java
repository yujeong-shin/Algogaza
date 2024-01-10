import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//class Point{
//    int x;
//    int y;
//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
public class ex2578_빙고 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, Point> map = new HashMap<>();
        int n = 5;
        int number_count = 0;
        int total_count = 0;
        int[] bingoRow = new int[n];
        int[] bingoColumn = new int[n];
        int[] bingoX = new int[2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                // map에 "숫자"-"(x좌표,y좌표)" 쌍으로 집어넣음
                map.put(Integer.parseInt(st.nextToken()), new Point(i, j));
            }
        }

        f1: for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int input_number = Integer.parseInt(st.nextToken());
                number_count++;

                Point point = map.get(input_number);
                bingoRow[point.x]++; // 가로 빙고 count
                bingoColumn[point.y]++; // 세로 빙고 count

                if (point.x == point.y) {
                    bingoX[0]++; // 우하향 대각선에 있는 값들
                }

                if (point.y == n - 1 - point.x) {
                    bingoX[1]++; // 좌하향 대각선에 있는 값들
                }

                // 빙고가 완성되었는지 확인
                if (bingoRow[point.x] == n) {
                    total_count++;
                    bingoRow[point.x] = 0; // 이미 확인한 빙고 초기화
                }

                if (bingoColumn[point.y] == n) {
                    total_count++;
                    bingoColumn[point.y] = 0;
                }

                if (bingoX[0] == n) {
                    total_count++;
                    bingoX[0] = 0;
                }

                if (bingoX[1] == n) {
                    total_count++;
                    bingoX[1] = 0;
                }

                // 3줄 이상 완성되었으면 결과 출력
                if (total_count >= 3) {
                    System.out.println(number_count);
                    break f1;
                }
            }
        }
    }
}