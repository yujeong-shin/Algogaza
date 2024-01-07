import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Q2933_미네랄 {
    static int H,W;
    static char[][] map;
    static int[] stick;
    static boolean left = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0; j<W; j++){
                map[i][j] = str.charAt(j);
            }
        }
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        stick = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            stick[i] = Integer.parseInt(st.nextToken());
        }

        for(int h : stick){
            crashMineral(h);
            left = !left;
        }
    }
    // 미네랄 부시기
    private static void crashMineral(int height) {
        if(left){
            for(int i=0; i<map[height].length; i++){
                if(map[height][i] == '*') {
                    map[height][i] = '.';
                    break;
                }
            }
        } else {
            for (int i = map[height].length - 1; i >= 0; i--) {
                if (map[height][i] == '*') {
                    map[height][i] = '.';
                    checkCluster(height, i);
                    break;
                }
            }
        }
    }
    // 클러스터인지 확인
    private static void checkCluster(int h, int w){
        // 클러스터 확인하는 방법?
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[H][W];
        queue.offer(new Point(h,w));
        visited[h][w] = true;

        while(!queue.isEmpty()){
            Point point = queue.poll();
            if(point.y-1 >=0 && point.y+1 < W){
                if(map[point.x][point.y-1] == '*'){
                    bfs(new Point(point.x, point.y-1));
                }
                if(map[point.x][point.y+1] == '*'){
                    bfs(new Point(point.x, point.y+1));
                }
            }
        }
    }
    private static boolean bfs(Point start){
        int[] dh = {-1,0,0,1};
        int[] dw = {0,1,-1,0};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            Point point = queue.poll();
            for(int i=0; i<4; i++){
                int nextH = point.x + dh[i];
                int nextW = point.y + dw[i];
                if(nextH>=0 && nextW>=0 && nextH<H && nextW<W && map[nextH][nextW] == '*'){

                }
            }
        }
    }
}
