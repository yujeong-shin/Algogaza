import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Q2589_보물섬 {
    static int H, W;
    static char[][] map;
    static int[][] distance;
    static boolean[][] visited;
    static int[] dh = {-1, 0, 0, 1};
    static int[] dw = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        distance = new int[H][W];
        visited = new boolean[H][W];

        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0; j<W; j++){
                map[i][j] = str.charAt(j);
            }
        }
        int result = 0;
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(map[i][j] == 'L'){
                    distance[i][j] = 0;
                    result = Math.max(result, bfs(new Point(i,j)));
                }
            }
        }
        System.out.println(result);
    }
    private static int bfs(Point point){
        int temp = 0;
        for(int i=0; i<visited.length; i++){
            Arrays.fill(visited[i], false);
        }
        Queue<Point> queue = new LinkedList<>();
        visited[point.x][point.y] = true;
        queue.offer(point);

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i=0; i<4; i++){
                int nextH = p.x + dh[i];
                int nextW = p.y + dw[i];

                if(nextH < 0 || nextW < 0 || nextH >= H || nextW >= W) continue;
                if(!visited[nextH][nextW] && map[nextH][nextW] == 'L'){
                    visited[nextH][nextW] = true;
                    queue.offer(new Point(nextH, nextW));
                    distance[nextH][nextW] = distance[p.x][p.y] + 1;
                    if(temp < distance[nextH][nextW]) temp = distance[nextH][nextW];
                }
            }
        }
        return temp;
    }
}
