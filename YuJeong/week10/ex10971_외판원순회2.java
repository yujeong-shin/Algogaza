import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex10971_외판원순회2 {
    static int N, answer;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            DFS(i, i, 0, 0);
        }

        System.out.println(answer);
    }

    static void DFS(int start, int now, int sum, int cnt){
        if(cnt==N-1){
            // 마지막노드에서 맨처음 노드로 가는 비용 더하기
            if(map[now][start] != 0){
                sum += map[now][start];
                answer = Math.min(answer, sum);
            }
        }
        else{
            for (int i = 0; i < N; i++) {
                if(map[now][i] != 0 && !visited[i]){ // 간선이 있고, 아직 도달하지 않은 도시일 경우
                    visited[i] = true;
                    DFS(start, i, sum+map[now][i], cnt+1);
                    visited[i] = false;
                }
            }
        }
    }
}