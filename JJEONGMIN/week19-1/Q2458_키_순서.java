import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2458_키_순서 {
    static int[][] map;
    static int INF = 500 * 500 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            map[A][B] = 1;
        }
        for (int m=1; m<=N; m++){
            for (int s=1; s<=N; s++) {
                for (int e=1; e<=N; e++){
                    if (map[s][e] > map[s][m] + map[m][e])
                        map[s][e] = map[s][m] + map[m][e];
                }
            }
        }
        int result = 0;
        for(int i=1; i<=N; i++){
            int temp = 1;
            for(int j=1; j<=N; j++){
                if(map[i][j] == INF && map[j][i] == INF){
                    temp = 0;
                    break;
                }
            }
            result += temp;
        }
        System.out.println(result);
    }
}
