import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2178 {
    static int H,W, count = 1;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};
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

    private static void bfs(int a, int b){
        Queue queue = new LinkedList<Point>();

        queue.offer(new Point(a, b));
        visited[a][b] = true;

        while(!queue.isEmpty()){
            Point p = (Point)queue.poll();
            int h = p.x;
            int w = p.y;
            if(h == H && w == W) break;

            for(int i=0; i<4; i++){
                int next_h = h+dy[i];
                int next_w = w+dx[i];

                if(next_h>=0 && next_h<=H && next_w>=0 && next_w<=W && map[next_h][next_w] == 1 && !visited[next_h][next_w]){
                    count++;
                    queue.offer(new Point(next_h, next_w));
                }
            }
        }
    }
}

