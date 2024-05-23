import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Q11404_플로이드 {
    static int[][] map;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        IntStream.range(1, N+1).forEach(i ->
                IntStream.range(1, N+1).forEach(j ->
                        map[i][j] = (i == j) ? 0 : INF
                )
        );
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[start][end] = Math.min(cost, map[start][end]);
        }
        for(int m=1; m<=N; m++){
            for(int s=1; s<=N; s++){
                for(int e=1; e<=N; e++){
                    if(map[s][m] != INF && map[m][e] != INF && map[s][e] > map[s][m] + map[m][e])
                        map[s][e] = map[s][m] + map[m][e];
                }
            }
        }

        IntStream.range(1, N+1).forEach(i -> {
            IntStream.range(1, N+1).forEach(j -> {
                if(map[i][j] == INF) System.out.print(0 + " ");
                else System.out.print(map[i][j] + " ");
            }
            );
            System.out.println();
            }
        );
    }
}
