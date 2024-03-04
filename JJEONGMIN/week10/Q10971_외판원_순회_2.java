import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10971_외판원_순회_2 {
    static int N, result = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            Arrays.fill(visited, false);
            visited[i] = true;
            dfs(i, i, 0, 0);
        }
        System.out.println(result);
    }
    private static void dfs(int start, int end, int count, int sum) {
        if(count == N-1) {
            if(map[start][end] == 0) return;
            result = Math.min(result, sum + map[start][end]);
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i] && start != i && map[start][i] != 0){
                visited[i] = true;
                dfs(i, end,count+1, sum+map[start][i]);
                visited[i] = false;
            }
        }
    }
}
