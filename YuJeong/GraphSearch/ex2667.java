import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex2667 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, townCount=0;
    static int[][] map;
    static List<Point> houses;
    static List<Integer> eachTownHouseCount;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        houses = new ArrayList<>();
        eachTownHouseCount = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String s = bf.readLine();
            for(int j=0; j<N; j++) {
                int num = s.charAt(j) - '0'; //한문자를 숫자로 변환해서 저장
                map[i][j] = num;
                if(num==1) houses.add(new Point(i, j)); //House들의 좌표 저장
            }
        }

        for(Point house : houses) { //House 돌며 연결된 집 개수 세기
            if(map[house.x][house.y]==1){
                townCount++; //총 단지수 Count
                map[house.x][house.y]=0;
                BFS(house.x, house.y);
            }
        }

        System.out.println(townCount);
        Collections.sort(eachTownHouseCount); //오름차순 정렬
        for(int houseCount : eachTownHouseCount) {
            System.out.println(houseCount);
        }

    }

    public static void BFS(int x, int y) {
        int count=1; //각 단지마다 집의 개수 Count
        map[x][y]=0;
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(x, y));

        while(!Q.isEmpty()) {
            Point cur = Q.poll();
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1) {
                    map[nx][ny]=0;
                    count++;
                    Q.add(new Point(nx, ny));
                }
            }
        }
        eachTownHouseCount.add(count);
    }
}
