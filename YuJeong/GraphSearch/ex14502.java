import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Point{
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class ex14502 {
    static final int dx[] = {-1, 0, 1, 0};  //상하좌우 방향 설정
    static final int dy[] = {0, 1, 0, -1};  //상화좌우 방향 설정
    static int originalMap[][];
    static int n,m;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        originalMap = new int[n][m];
        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                originalMap[i][j]=sc.nextInt();
            }
        }
        ex14502.DFS(0);
        System.out.println(answer);
    }

    public static void DFS(int wallCount) {
        if(wallCount==3){
            BFS();
            return;
        }

        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if(originalMap[i][j]==0) {
                    originalMap[i][j]=1;
                    DFS(wallCount+1);
                    originalMap[i][j]=0;
                }
            }
        }
    }

    public static void BFS(){
        Queue<Point> Q = new LinkedList<>();
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i][j] = originalMap[i][j];
                if(map[i][j]==2) Q.offer(new Point(i, j));
            }
        }

        while(!Q.isEmpty()) {
            Point cur = Q.poll();
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]==0){
                    map[nx][ny]=2;
                    Q.offer(new Point(nx, ny));
                }
            }
        }

        countSafeZone(map);
    }

    public static void countSafeZone(int[][] map){
        int cnt=0;
        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(map[i][j]==0) cnt++;
            }
        }

        answer = Math.max(answer, cnt);
    }


}
