import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_2178 {
    static boolean[][] visited;
    static int[][] array;
    static int[] dx = {0, 0, -1, 1}; //up, down, left, right
    static int[] dy = {-1, 1, 0, 0}; //up, down, left, right
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //building up graph
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String l = br.readLine();
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(l.substring(j, j + 1));
            }
        }
        bfs(0, 0);
        System.out.print(array[N-1][M-1]);
    }

    public static void bfs(int a, int b) {
        Deque<int[]> deque = new ArrayDeque<int[]>();
        deque.add(new int[]{a, b});
        visited[a][b] = true;
        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            for (int d = 0; d < 4; d++) {
                int x = now[0] + dx[d];
                int y = now[1] + dy[d];
                if(x >= 0 && y >= 0 && x < N && y < M){
                    if(!visited[x][y] && array[x][y] != 0){
                        visited[x][y] = true;
                        array[x][y] = array[now[0]][now[1]] + 1;
                        deque.add(new int[] {x,y});
                    }
                }
            }
        }
    }
}
