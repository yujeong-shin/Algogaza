import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;

public class Q7562 {
    static int T, I;
    static int[][] map, count;
    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {2,1,-1,-2,-2,-1,1,2};
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            I = Integer.parseInt(br.readLine());

            map = new int[I][I];
            count = new int[I][I];
            st = new StringTokenizer(br.readLine());
            int start_H = Integer.parseInt(st.nextToken());
            int start_W = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int end_H = Integer.parseInt(st.nextToken());
            int end_W = Integer.parseInt(st.nextToken());

            bfs(start_H, start_W, end_H, end_W);
            result.append(count[end_H][end_W]);
            result.append('\n');
        }
        System.out.println(result);
    }

    private static void bfs(int start_H, int start_W, int end_H, int end_W){
        Queue queue = new LinkedList<Point>();
        queue.offer(new Point(start_H, start_W));
        count[start_H][start_W] = 0;

        while(!queue.isEmpty()){
            Point p = (Point)queue.poll();
            if(p.x == end_H && p.y == end_W) break;

            for(int i=0; i<8; i++){
                int next_H = p.x + dy[i];
                int next_W = p.y + dx[i];

                if(next_H>=0 && next_H<I && next_W>=0 && next_W<I && map[next_H][next_W]==0){
                    map[next_H][next_W] = 1;
                    queue.offer(new Point(next_H,next_W));
                    count[next_H][next_W] = count[p.x][p.y] + 1;
                }
            }
        }


    }
}
