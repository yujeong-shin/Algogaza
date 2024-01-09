import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        int h = H - height;
        if(left){
            for(int i=0; i<map[h].length; i++){
                if(map[h][i] == 'x') {
                    map[h][i] = '.';
                    checkCluster(h,i);
                    break;
                }
            }
        } else {
            for (int i = map[h].length - 1; i >= 0; i--) {
                if (map[h][i] == 'x') {
                    map[h][i] = '.';
                    checkCluster(h,i);
                    break;
                }
            }
        }
    }
    // 공중에 떠 있는 미네랄 클러스터 확인(bfs)
    private static void checkCluster(int h, int w){
        int[] dh = {-1,0,0,1};
        int[] dw = {0,1,-1,0};
        Queue<Point> queue = new LinkedList<>();
        ArrayList<Point> clusterList = new ArrayList<>();
        boolean[][] visited = new boolean[H][W];
        queue.offer(new Point(h,w-1));
        queue.offer(new Point(h,w+1));
        visited[h][w-1] = true;
        visited[h][w+1] = true;
        if(map[h][w-1] == 'x')clusterList.add(new Point(h, w-1));
        if(map[h][w+1] == 'x')clusterList.add(new Point(h, w+1));

        while(!queue.isEmpty()){
            Point point = queue.poll();
            for(int i=0; i<4; i++){
                int nextH = point.x + dh[i];
                int nextW = point.y + dw[i];
                if(nextH>=0 && nextW>=0 && nextH<H && nextW<W && map[nextH][nextW] == 'x' && !visited[nextH][nextW]){
                    if(nextH == H-1) return;
                    visited[nextH][nextW] = true;
                    queue.offer(new Point(nextH,nextW));
                    clusterList.add(new Point(nextH,nextW));
                }
            }
        }
        return;
    }
}
