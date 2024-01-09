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
        int number_count=0;
        int total_count=0;
        int[] bingoRow = new int[n];
        int[] bingoColumn = new int[n];
        int[] bingoX = new int[2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                //map에 "숫자"-"(x좌표,y좌표)" 쌍으로 집어넣음
                map.put(Integer.parseInt(st.nextToken()), new Point(i, j));
            }
        }
//        원하는대로 잘 들어갔네?
//        Set<Integer> keySet = map.keySet();
//        for (Integer key : keySet) {
//            System.out.println(key + " : " + map.get(key).x + ", " + map.get(key).y);
//        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                // 사회자의 입력값 하나씩 받자
                int input_number = Integer.parseInt(st.nextToken());
                System.out.println("input_number = " + input_number);
                number_count++;
                System.out.println("number_count = " + number_count);

                Point point = map.get(input_number);
                System.out.println("사회자가 부른 숫자에 대한 좌표값 : " +  point.x + ", " + point.y);

                bingoRow[point.x]++; //가로 빙고 count
                System.out.println("point.x : " + point.x + ", bingoRow[point.x] : " + bingoRow[point.x]);
                if(bingoRow[point.x]==n) total_count++;
                System.out.println("total_count = " + total_count);

                bingoColumn[point.y]++; //세로 빙고 count
                System.out.println("point.y : " + point.y +", bingoColumn[point.y] : " + bingoColumn[point.y]);
                if( bingoColumn[point.y]==n) total_count++;
                System.out.println("total_count = " + total_count);

                if(point.x == point.y) bingoX[0]++; //우하향 대각선에 있는 값들
                if(bingoX[0]==n) total_count++;
                if(point.y == n-(point.x)+1) bingoX[1]++; //좌하향 대각선에 있는 값들
                if(bingoX[1]==n) total_count++;

                if(total_count==3) System.out.println(number_count);
            }
        }
    }
}
