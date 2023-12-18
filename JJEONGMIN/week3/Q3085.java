import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3085 {
    static class Candy{
        int h;
        int w;
        char type;
        public Candy(int h, int w, char type){
            this.h = h;
            this.w = w;
            this.type = type;
        }
    }
    static int N;
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N][N];
        map = new char[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = str.charAt(j);
            }
        }


    }
    // 사탕 종류 빨간색:C, 파란색:P, 초록색:Z, 노란색:Y
    private static void bfs(int h, int w){
        int[] dh = {0,1,0,-1};
        int[] dw = {-1,0,0,1};
        Queue<Candy> queue = new LinkedList<>();
        queue.offer(new Candy(h,w, map[h][w]));

        while(!queue.isEmpty()){
            Candy candy = (Candy) queue.poll();
            for(int i=0; i<4; i++){
                int next_h = candy.h + dh[i];
                int next_w = candy.w + dw[i];

                if(next_h>=0 && next_h<N && next_w>=0 && next_w<N &&map[next_h][next_w] == candy.type && !visited[next_h][next_w]){
                    visited[next_h][next_w] = true;
                }
            }
        }

    }
}
