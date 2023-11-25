import java.util.*;

public class ex1012 {
    static int M, N, K, count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void DFS(int x, int y, int[][] board){
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<M && ny>=0 && ny<N && board[nx][ny]==1) {
                board[nx][ny]=0;
                DFS(nx, ny, board);
            }
        }
    }

    public static void count(int[][] board){
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(board[i][j] == 1) {
                    count++;
                    board[i][j]=0;
                    DFS(i, j, board);
                }
            }
        }
    }

    /*
    public static void printBoard(int[][] board){
        for(int i=0; i<M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    */

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
            //printBoard(board);
            ex1012.count(board);
            System.out.println(count);
        }
    }
}