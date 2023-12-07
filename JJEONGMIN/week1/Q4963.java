import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q4963 {
    static int W, H, sum =0;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W==0 && H==0) break;

            map = new int[H][W];
            visited = new boolean[H][W];
            for(int i = 0; i < H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        sum++;
                        bfs(i,j);
                    }
                }
            }
            System.out.println(sum);
        }
    }

    private static void bfs(int h, int w){
        Queue<Integer> h_queue = new LinkedList<Integer>();
        h_queue.offer(h);

        while(!h_queue.isEmpty()){
            int n = h_queue.poll();

            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    visited[n][j] = true;
                    h_queue.offer(n);
                }
            }
        }
    }
}
