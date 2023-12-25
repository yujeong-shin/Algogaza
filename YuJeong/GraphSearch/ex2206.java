import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class ex2206 {
    static int[][] graph, count;
    static boolean[][][] visited;
    static Queue<int[]> Q = new LinkedList<>();
    static int N, M;

    static int[] dx = { -1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로의 수
        M = Integer.parseInt(st.nextToken()); // 가로의 수

        visited = new boolean[N + 1][M + 1][2];
        graph = new int[N + 1][M + 1];
        count = new int[N + 1][M + 1];

        // (1, 1) 시작 (N, M) 종료
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                char ch = str.charAt(j - 1);
                graph[i][j] = Character.getNumericValue(ch);
            }
        }
        bfs();
    }

    static void bfs() {
        // (1, 1) 시작, 아직 벽을 부순 적 없으니 세 번째 값은 0으로 세팅
        Q.add(new int[] { 1, 1, 0 });
        visited[1][1][0] = true;
        visited[1][1][1] = true;
        count[1][1] = 1; // 시작하는 칸도 포함해서 센다
        while (!Q.isEmpty()) {
            int[] arr = Q.poll();
            int x = arr[0]; // 현재 x좌표
            int y = arr[1]; // 현재 y좌표
            int brokeOnce = arr[2]; //지금껏 한 번이라도 벽을 부신적 있으면 1, 없으면 0

            if(x == N && y == M){
                System.out.println(count[N][M]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
                    if (graph[nx][ny] == 1 && brokeOnce == 0) {
                        // 벽을 만났는데 지금까지 벽을 한 번도 안부셔서, 부시고 갈 수 있는 경우
                        // 세 번째 값을 1로 세팅해, 앞으로는 벽을 못 부시도록 만든다
                        // Q에 담긴 (nx, ny, 1)이 나중에 poll()되면서
                        // 다른 벽을 만나면 탐색하지 않고 종료, 이동 가능한 칸을 만나면 아래 if문으로 들어가서 전진한다
                        Q.add(new int[] { nx, ny, 1 });
                        count[nx][ny] = count[x][y] + 1;
                    }

                    if (graph[nx][ny] == 0) {
                        // 이동 가능한 칸을 만나면, 벽을 부셨든 안부셨든 관계없이 전진 가능
                        // 대신 벽을 부시고 이동하는 중인지, 벽을 부시지 않고 이동하는 중인지 visited 3차원 배열에 표시
                        if (visited[nx][ny][brokeOnce] == false) {
                            Q.add(new int[] { nx, ny, brokeOnce });
                            visited[nx][ny][brokeOnce] = true;
                            count[nx][ny] = count[x][y] + 1;
                        }
                    }

                }
            }
        }
        System.out.println(-1);
    }
}