import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Q15683_감시 {
    static class CCTV {
        int number;
        Point point;
        public CCTV(int number, Point point){
            this.number = number;
            this.point = point;
        }
    }
    static int[][] map;
    static List<CCTV> cctvList = new ArrayList<>();
    static List<CCTV> cctv5List = new ArrayList<>();
    static List<Integer> directions = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                int number = Integer.parseInt(st.nextToken());
                map[i][j] = number;
                if(number != 0 && number != 6 && number != 5){
                    cctvList.add(new CCTV(number, new Point(i, j)));
                }
            }
        }

        if(!cctv5List.isEmpty()) {
            for (CCTV value : cctv5List) {
                checkDown(map, value.point);
                checkUp(map, value.point);
                checkLeft(map, value.point);
                checkRight(map, value.point);
            }
        }

        visited = new boolean[cctvList.size()];
        cctvDirection(0);

    }
    private static void cctvDirection(int num){
        if(directions.size() == cctvList.size()){
            System.out.println(directions);
            int[][] tempMap = map.clone();
            for (int i=0; i<cctvList.size(); i++) {
                CCTV(tempMap, directions.get(i), cctvList.get(i));
            }
            result = Math.min(result, checkSpot(tempMap));
        }

        for(int i=num; i<cctvList.size(); i++){
            for(int j=1; j<5; j++){
                directions.add(j);
                cctvDirection(i + 1);
                directions.remove(directions.size()-1);
            }
        }
    }
    private static void CCTV(int[][] tempMap, int direction, CCTV cctv){
        if(cctv.number == 1) {

        } else if (cctv.number == 2) {

        } else if (cctv.number == 3) {

        } else if (cctv.number == 4) {

        }
    }
    private static int checkSpot(int[][] tempMap){
        int count = 0;
        for(int i=0; i<tempMap.length; i++){
            for(int j=0; j<tempMap[0].length; j++){
                if(tempMap[i][j] == 0) count++;
            }
        }
        return count;
    }
    private static void checkLeft(int[][] tempMap, Point point){
        while(true){
            int nextW = point.y - 1;
            if(nextW < 0 || tempMap[point.x][nextW] == 6) return;
            if(tempMap[point.x][nextW] == 0) tempMap[point.x][nextW] = 7;
        }
    }
    private static void checkRight(int[][] tempMap, Point point){
        while(true){
            int nextW = point.y + 1;
            if(nextW >= tempMap[0].length || tempMap[point.x][nextW] == 6) return;
            if(tempMap[point.x][nextW] == 0) tempMap[point.x][nextW] = 7;
        }
    }
    private static void checkUp(int[][] tempMap, Point point){
        while(true){
            int nextX = point.x + 1;
            if(nextX >= tempMap.length || tempMap[nextX][point.y] == 6) return;
            if(tempMap[nextX][point.y] == 0) tempMap[nextX][point.y] = 7;
        }
    }
    private static void checkDown(int[][] tempMap, Point point){
        while(true){
            int nextX = point.x - 1;
            if(nextX < 0 || tempMap[nextX][point.y] == 6) return;
            if(tempMap[nextX][point.y] == 0) tempMap[nextX][point.y] = 7;
        }
    }
}
