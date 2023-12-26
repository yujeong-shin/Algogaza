import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3085_사탕_게임 {
    static int N;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = str.charAt(j);
            }
        }

        int max_count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                max_count = Math.max(max_count, swap(i,j));
            }
        }
        System.out.println(max_count);
    }

    private static int count() {
        int max_candy = 0;
        for(int i=0; i<N; i++){
            int count_w = 1;
            int count_h = 1;
            for(int j=0; j<N-1; j++){
                if(map[i][j] == map[i][j+1]) {
                    count_w++;
                    max_candy = Math.max(max_candy,count_w);
                }
                else count_w = 1;
                if(map[j][i] == map[j+1][i]) {
                    count_h++;
                    max_candy = Math.max(max_candy,count_h);
                }
                else count_h = 1;
            }
        }
        return max_candy;
    }

    private static int swap(int cur_h, int cur_w) {
        int result = 0;
        int[] dh = {0,1,-1,0};
        int[] dw = {-1,0,0,1};

        for(int i=0; i<4; i++){
            int next_h = cur_h + dh[i];
            int next_w = cur_w + dw[i];
            if(next_w>=0 && next_w<N && next_h>=0 && next_h<N){
                if(map[cur_h][cur_w] != map[next_h][next_w]){
                    char temp = map[cur_h][cur_w];
                    map[cur_h][cur_w] = map[next_h][next_w];
                    map[next_h][next_w] = temp;
                    result = Math.max(result, count());
                    map[next_h][next_w] = map[cur_h][cur_w];
                    map[cur_h][cur_w] = temp;
                }
            }
        }
        return result;
    }
}
