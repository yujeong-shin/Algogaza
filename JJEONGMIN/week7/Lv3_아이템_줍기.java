import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class Lv3_아이템_줍기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        System.out.println(solution.takeItem(rectangle, characterX, characterY, itemX, itemY));
    }

    static class Solution {
        static int[][] map = new int[101][101];
        static int[][] distance = new int[101][101];
        static boolean[][] visited = new boolean[101][101];
        static int[] dh = {-1, 0, 0, 1};
        static int[] dw = {0, -1, 1, 0};

        // 매개변수 : 맵(2차원 배열), 케릭터 좌표, 아이템 좌표
        public int takeItem(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            for(int i=0; i<rectangle.length; i++){
                fill(2*rectangle[i][0], 2*rectangle[i][1], 2*rectangle[i][2], 2*rectangle[i][3]);
            }
            checkDistance(new Point(2*characterY, 2*characterX), new Point(2*itemY, 2*itemX));
            return distance[2*itemY][2*itemX]/2;
        }

        public void fill(int x1, int y1, int x2, int y2){
            for(int i=y1; i<=y2; i++){
                for(int j=x1; j<=x2; j++){
                    if(map[i][j]==2) continue;
                    map[i][j]=2;
                    if(i==y1||i==y2||j==x1||j==x2){
                        map[i][j]=1;
                    }
                }
            }
        }
        private static void checkDistance(Point character, Point item) {
            Queue<Point> queue = new LinkedList<>();
            queue.offer(character);
            visited[character.x][character.y] = true;
            while (!queue.isEmpty()) {
                Point p = queue.poll();
                if(p.x == item.x && p.y == item.y) break;
                for (int i = 0; i < 4; i++) {
                    int nextH = p.x + dh[i];
                    int nextW = p.y + dw[i];
                    if (nextH >= 0 && nextW >= 0 && nextH <= 50 && nextW <= 50) {
                        if (!visited[nextH][nextW] && map[nextH][nextW] == 1) {
                            visited[nextH][nextW] = true;
                            distance[nextH][nextW] = distance[p.x][p.y] + 1;
                            queue.offer(new Point(nextH, nextW));
                        }
                    }
                }
            }
        }
    }
}