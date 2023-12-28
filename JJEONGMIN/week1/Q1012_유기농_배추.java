import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1012_유기농_배추 {
    static int M, N, K, sum =0;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());

        for(int a = 0; a < num; a++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            sum = 0;

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
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

    private static void dfs(int h, int w) {
        for(int i=0; i<4; i++){
            int next_h = h+dx[i];
            int next_w = w+dy[i];

            if(next_w>=0 && next_w<M && next_h>=0 && next_h<N && map[next_h][next_w] == 1 && !visited[next_h][next_w]){
                visited[next_h][next_w] = true;
                dfs(next_h, next_w);
            }
        }
    }
}
