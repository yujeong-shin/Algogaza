import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2636 {
    static int H,W, cheese = 0, time = 1;
    static int[][] map;
    static boolean[][] visited;
    static int[] dh = {-1,0,0,1};
    static int[] dw = {0,1,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W];

        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    bfs(i,j);
                    if(checkNull()){
                        countCheese();
                        System.out.println(time);
                        System.out.println(cheese);
                        return;
                    }
                    removeCheese();
                }
            }
        }
    }
    private static void bfs(int h, int w){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(h,w));
        visited[h][w] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i=0; i<4; i++){
                int next_h = p.x + dh[i];
                int next_w = p.y + dw[i];

                if(next_h>=0 && next_h<H && next_w>=0 && next_w<W) {
                    if (!visited[next_h][next_w]){
                        if(map[next_h][next_w] == 1){
                            map[next_h][next_w] = 2;
                            visited[next_h][next_w] = true;
                        }
                        else {
                            visited[next_h][next_w] = true;
                            queue.offer(new Point(next_h,next_w));
                        }
                    }
                }
            }
        }
    }

    private static void removeCheese() {
        for(int i=0; i<H; i++){
            Arrays.fill(visited[i], false);
            for(int j=0; j<W; j++){
                if(map[i][j] == 2)
                    map[i][j] = 0;
            }
        }
        time++;
    }

    private static boolean checkNull() {
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(map[i][j] == 1) return false;
            }
        }
        return true;
    }

    private static void countCheese() {
        cheese = 0;
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(map[i][j] == 2) cheese++;
            }
        }
    }
}
