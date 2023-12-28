import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4963_섬의_개수 {
    static int W, H, sum =0;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            sum = 0;
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
                        visited[i][j] = true;
                        sum++;
                        dfs(i,j);
                    }
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    // d..f..s...?
    private static void dfs(int h, int w) {
        for(int i=0; i<8; i++){
            int next_h = h+dx[i];
            int next_w = w+dy[i];

            if(next_w>=0 && next_w<W && next_h>=0 && next_h<H && map[next_h][next_w] == 1 && !visited[next_h][next_w]){
                visited[next_h][next_w] = true;
                dfs(next_h, next_w);
            }
        }
    }
}
