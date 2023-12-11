import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class ex2206 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, answer=Integer.MAX_VALUE;
    static int[][] map;
    static List<Point> walls;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        walls = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String s = bf.readLine();
            for (int j = 1; j <= s.length(); j++) {
                int isWall = s.charAt(j-1) - '0';
                if(isWall == 1) walls.add(new Point(i, j));
                map[i][j] = isWall;
            }
        }

        for(Point p : walls) {
            map[p.x][p.y]=0;
            answer = Math.min(answer, BFS());
            map[p.x][p.y]=1;
        }
        System.out.println(answer);
    }

    public static int BFS(){
        //깊은 복사
        int[][] copyMap = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        //copyMap : 복사된 map
        //countMap : (1,1)부터 각 칸까지 경로 길이
        int[][] countMap = new int[n+1][m+1];
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(1, 1));
        countMap[1][1] = 1; //출발점은 1
        while (!Q.isEmpty()){
            Point now = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx>=1 && nx<=n && ny>=1 && ny<=m && copyMap[nx][ny]==0){
                    copyMap[nx][ny]=1;
                    countMap[nx][ny] = countMap[now.x][now.y] + 1;
                    Q.add(new Point(nx, ny));
                }
            }
        }
        if(countMap[n][m]==0) return -1;
        else return countMap[n][m];
    }

    public static void printMap(int[][] map){
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
