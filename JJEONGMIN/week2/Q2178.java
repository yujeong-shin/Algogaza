import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2178 {
    static int H,W, count = 1;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[H+1][W+1];
        visited = new boolean[H+1][W+1];

        for(int i = 1; i <= H; i++) {
            String str = br.readLine();
            for(int j = 1; j <= W; j++){
                map[i][j] = str.charAt(j-1) - '0';
            }
        }

        bfs(1,1);
        System.out.println(count);
    }

    private static void bfs(int h, int w){
        Queue queue = new LinkedList<Point>();

        queue.offer(new Point(h, w));
        visited[h][w] = true;

        while(!queue.isEmpty()){
            Point p = (Point)queue.poll();
            int x = p.x;
            int y = p.y;

            for(int i = 1; i<=H; i++){
                for(int j = 1; j<=W; j++){
                    if(map[x][y] == 1 && !visited[x][y]) {
                        visited[x][y] = true;
                        count++;
                        queue.offer(new Point(i,j));
                    }
                }
            }
        }
    }
}

