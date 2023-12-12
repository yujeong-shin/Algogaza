import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Q2206 {
    static int[][] map, map2;
    static int[][][] count;
    static ArrayList<Integer> result;
    static boolean[][] visited;
    static boolean[] is_crash;
    static int H,W, walls = 0;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        result = new ArrayList<Integer>();

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        map2 = new int[H][W];

        for(int i=0; i<H; i++){
            String str = br.readLine();
            for(int j=0; j<W; j++) {
                map[i][j] = str.charAt(j) - '0';
                if(map[i][j] == 1) walls++;
            }
        }

        for(int i=0; i<map.length; i++){
            map2[i] = map[i].clone();
        }

        count = new int[walls][H][W];
        visited = new boolean[H][W];
        is_crash = new boolean[walls];

        bfs(0,0);
        Collections.sort(result);
        while(result.remove(Integer.valueOf(0)));

        if(result.isEmpty()) System.out.println(-1);
        else System.out.println(result.get(0));
    }
    private static void bfs(int start_H, int start_W){
        Queue queue = new LinkedList<Integer>();

        for(int i=0; i<walls; i++)
        {
            queue.offer(new Point(start_H, start_W));
            count[i][0][0] = 1;
            is_crash[i] = false;

            for(int k=0; k>map.length; k++){
                map[i] = map2[i].clone();
            }

            while(!queue.isEmpty()){
                Point p = (Point) queue.poll();
                if(p.x == H-1 && p.y == W-1) break;

                for(int j=0; j<4; j++) {
                    int next_H = p.x + dy[j];
                    int next_W = p.y + dx[j];

                    if (next_W >= 0 && next_W < W && next_H >= 0 && next_H < H){
                        if(map[next_H][next_W] == 1 && is_crash[i]) continue;
                        else if(map[next_H][next_W] == 1 && !is_crash[i] && !visited[next_H][next_W]){
                            is_crash[i] = true;
                            visited[next_H][next_W] = true;
                            count[i][next_H][next_W] = count[i][p.x][p.y] + 1;
                            queue.offer(new Point(next_H, next_W));
                        }
                        else if(map[next_H][next_W] == 0 && !visited[next_H][next_W]){
                            map[next_H][next_W] = 1;
                            queue.offer(new Point(next_H,next_W));
                            count[i][next_H][next_W] = count[i][p.x][p.y] + 1;
                        }
                    }
                }
            }
            result.add(count[i][H-1][W-1]);
        }
    }
}
