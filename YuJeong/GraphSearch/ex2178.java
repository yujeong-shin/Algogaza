import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex2178 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] map, dis;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken()); //4 미로 행
        M = Integer.parseInt(st.nextToken()); //6 미로 열
        map = new int[N+1][M+1]; // (1,1) 시작, (N,M) 도착
        dis = new int[N+1][M+1]; // (1,1) ~ (N,M)까지 거리 count
        for(int i=1; i<=N; i++){
            int j=1;
            st = new StringTokenizer(bf.readLine()); //map 정보 한줄 읽기
            String EachRow = st.nextToken();
            for(char ch : EachRow.toCharArray()) {
                map[i][j] = Integer.parseInt(String.valueOf(ch)); //숫자 하나씩 map에 저장
                j++;
            }
        }
        map[1][1]=0;
        dis[1][1]=1;
        BFS(1,1);
        System.out.println(dis[N][M]);
    }
    public static void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(x, y));
        while(!Q.isEmpty()) {
            Point cur = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx>=1 && nx<=N && ny>=1 && ny<=M && map[nx][ny]==1) {
                    map[nx][ny]=0;
                    Q.add(new Point(nx, ny));
                    dis[nx][ny] = dis[cur.x][cur.y]+1; //이전 count수 + 1
                }
            }
        }
    }
}