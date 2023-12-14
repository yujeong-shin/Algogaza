import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_4963 {
    static boolean[][] visited;
    static int[][] array;
    static int w;
    static int h;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count = 0;
    static List<Integer> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //building up a graph

        while(true) {
            count=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 & h==0){
                break;
            }
            visited = new boolean[h][w];
            array = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (array[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            res.add(count);
        }
        for(int r = 0; r < res.size(); r++){
            System.out.println(res.get(r));
        }
    }

    private static void bfs(int a, int b) {
        Deque<int[]> deque = new ArrayDeque<>();
        visited[a][b] = true;
        deque.add(new int[]{a, b});
        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            for (int d = 0; d < 4; d++) {
                for (int dd = 0; dd < 4; dd++) {
                    int x = now[0] + dx[d];
                    int y = now[1] + dy[dd];
                    if (x >= 0 && y >= 0 && x < h && y < w) {
                        if (!visited[x][y] && array[x][y] == 1) {
                            visited[x][y] = true;
                            deque.add(new int[]{x, y});
                        }
                    }
                }
            }
        }
        count++;
    }
}
