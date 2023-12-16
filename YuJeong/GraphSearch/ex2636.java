import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex2636 {
    static int[] dx={-1, 0, 1, 0}, dy={0, 1, 0, -1};
    static int n, m, meltingHours, countOfCheese;
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
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]==0) { //치즈가 아닌 곳 중에
                    if(isAir(i, j) || isEdge(i, j)) { //공기이거나 테두리이면
                        BFS(i, j); //주변 치즈 녹이기
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                meltingHours=Math.max(meltingHours, countHour[i][j]);
            }
        }
        System.out.println(meltingHours);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(countHour[i][j] == meltingHours-1) countOfCheese += 1;
            }
        }
        System.out.println(countOfCheese);
    }

    static boolean isAir(int x, int y){
        //board에서 0으로 체크된 칸이 공기인지 구멍인지 판별하는 메소드
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(x, y));
        boolean[][] visit = new boolean[n][m];
        visit[x][y]=true;
        while (!Q.isEmpty()) {
            Point now = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                //주변에 벽이 있다면 공기
                if(isEdge(nx, ny)) {
                    return true;
                }
                //주변에 방문하지 않은 공기 혹은 구멍이 있다면 포함해 벽 탐색
                if(board[nx][ny]==0 && !visit[nx][ny]){
                    visit[nx][ny]=true;
                    Q.add(new Point(nx, ny));
                }
            }
        }
        //주변에 벽이 없다면 구멍
        return false;
    }
    static boolean isEdge(int x, int y){
        if(x==0 || x==n-1 || y==0 || y==m-1) return true;
        else return false;
    }

    static void BFS(int x, int y){
        //공기 혹은 테두리 주변의 치즈 녹이기
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(x, y));
        while (!Q.isEmpty()) {
            Point now = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]==1){
                    board[nx][ny]=0;
                    countHour[nx][ny] = countHour[now.x][now.y] + 1;
                    Q.add(new Point(nx, ny));
                }
            }
        }
    }
}
