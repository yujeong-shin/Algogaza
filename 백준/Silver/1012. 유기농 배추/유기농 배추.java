import java.util.*;

class Point{
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int M, N, K, count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> Q = new LinkedList<>();

    public static void BFS(int x, int y,  int[][] board) {
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) {
                Point cur = Q.poll();
                for(int j=0; j<4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if(nx>=0 && nx<M && ny>=0 && ny<N && board[nx][ny]==1) {
                        board[nx][ny]=0;
                        Q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static void count(int[][] board){
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(board[i][j] == 1) {
                    count++;
                    board[i][j]=0;
                    Q.offer(new Point(i, j));
                    BFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++) {
            count=0;
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            int[][] board = new int[M][N];
            for(int j=0; j<K; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                board[x][y] = 1;
            }
            Main.count(board);
            System.out.println(count);
        }
    }
}