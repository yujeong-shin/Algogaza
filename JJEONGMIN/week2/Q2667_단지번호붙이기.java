import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q2667_단지번호붙이기 {
    static int N, dangi = 0, apart;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];
        visited = new boolean[N][N];
        ArrayList<Integer> apt_arr = new ArrayList<>(N);

        for(int i=0; i<N; i++){
            String input = sc.next();
            for(int j=0; j<N; j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    dangi++;
                    apart = 1;
                    dfs(i,j);
                    apt_arr.add(apart);
                }
            }
        }
        Collections.sort(apt_arr);
        System.out.println(dangi);
        for(int i=0; i<dangi; i++)
            System.out.println(apt_arr.get(i));
    }
    private static void dfs(int h, int w){
        visited[h][w] = true;
        for(int i=0; i<4; i++){
            int next_h = h+dy[i];
            int next_w = w+dx[i];

            if(next_h>=0 && next_h<N && next_w>=0 && next_w<N && map[next_h][next_w]==1 && !visited[next_h][next_w]) {
                apart++;
                dfs(next_h,next_w);
            }
        }
    }
}
