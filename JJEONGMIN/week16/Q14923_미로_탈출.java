import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14923_미로_탈출 {
    static class Hongik{
        int H;
        int W;
        int count;
        boolean distroy;
        public Hongik(int H, int W, int count,  boolean distroy){
            this.H = H;
            this.W = W;
            this.count = count;
            this.distroy = distroy;
        }
        public void plusCount(){
            this.count++;
        }
    }
    static int[][] map;
    static boolean[][][] visited;
    static int[][][] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[2][N][M];
        distance = new int[2][N][M];

        st = new StringTokenizer(br.readLine());
        int sH = Integer.parseInt(st.nextToken());
        int sW = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int eH = Integer.parseInt(st.nextToken());
        int eW = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs(N, M, sH-1, sW-1, eH-1, eW-1);
        System.out.println(result);

    }
    public static int bfs(int N, int M, int sH, int sW, int eH, int eW){
        int[] dh = {-1, 0, 0, 1};
        int[] dw = {0, -1, 1, 0};
        Queue<Hongik> queue = new LinkedList<>();
        queue.offer(new Hongik(sH, sW, 0, false));

        while(!queue.isEmpty()){
            Hongik hongik = queue.poll();
            if(hongik.H == eH && hongik.W == eW) {
                return hongik.count;
            }
            for(int i=0; i<4; i++){
                int nextH = hongik.H + dh[i];
                int nextW = hongik.W + dw[i];
                int nextCnt = hongik.count + 1;
                if(nextH < 0 ||  nextW < 0 || nextH >= N || nextW >= M) continue;
                if(map[nextH][nextW] == 0){
                    if(!hongik.distroy && !visited[0][nextH][nextW]){
                        visited[0][nextH][nextW] = true;
                        distance[0][nextH][nextW] = distance[0][hongik.H][hongik.W] + 1;
                        queue.offer(new Hongik(nextH, nextW, nextCnt, false));
                    } else if (hongik.distroy && !visited[1][nextH][nextW]) {
                        visited[1][nextH][nextW] = true;
                        distance[1][nextH][nextW] = distance[1][hongik.H][hongik.W] + 1;
                        queue.offer(new Hongik(nextH, nextW, nextCnt, true));
                    }
                } else if(map[nextH][nextW] == 1) {
                    if(!hongik.distroy) {
                        visited[1][nextH][nextW] = true;
                        distance[1][nextH][nextW] = distance[0][hongik.H][hongik.W] + 1;
                        queue.offer(new Hongik(nextH, nextW, nextCnt, true));
                    }
                }
            }
        }
        return -1;
    }
}
