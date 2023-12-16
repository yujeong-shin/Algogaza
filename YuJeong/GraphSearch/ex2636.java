import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex2636 {
    static int[] dx={-1, 0, 1, 0}, dy={0, 1, 0, -1};
    static int n, m, time, cheese;
    static int[][] board, countHour;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        countHour = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1)
                    cheese++;
            }
        }

        int answer=0;
        while(cheese != 0){
            time++;
            answer = cheese;
            BFS(0, 0);
        }

        System.out.println(time);
        System.out.println(answer);
    }


    static void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(x, y));
        boolean[][] visited = new boolean[n][m];
        visited[x][y]=true;

        while (!Q.isEmpty()) {
            Point now = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    //치즈라면 녹여주고
                    if(board[nx][ny]==1){
                        cheese--;
                        board[nx][ny]=0;
                    }
                    //치즈가 아니라면 확장하면서 주변 치즈탐색
                    else {
                        Q.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
}