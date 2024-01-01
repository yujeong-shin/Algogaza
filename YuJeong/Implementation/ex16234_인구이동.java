import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Country{
    int x, y;
    public Country(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class ex16234_인구이동 {
    static final int dx[] = {-1, 0, 1, 0};
    static final int dy[] = {0, 1, 0, -1};
    static boolean visit[][];
    static int map[][];
    static int n, l, r, cnt;
    static boolean isMove;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move();

        System.out.println(cnt);

    }
    static void move() {
        while(true) {
            isMove = false;
            visit = new boolean[n][n]; //새로 BFS 시작할때마다 방문 초기화

            for(int i=0; i<n; i++) {
                for(int j=0;j<n; j++) {
                    if(!visit[i][j]){
                        bfs(i,j);    //방문하지 않은상태면 BFS 시작
                    }
                }
            }

            if(!isMove) break; //국경 이동이 없을 때까지 반복
            else cnt++; //국경 이동이 있었다면 일수 추가.
        }
    }
    static void bfs(int x, int y){
        Queue<Country> Q = new LinkedList<>();
        List<Country> unionCountry = new ArrayList<>();
        visit[x][y] = true;
        Q.add(new Country(x, y));
        unionCountry.add(new Country(x, y));

        while(!Q.isEmpty()){
            Country country = Q.poll();
            x = country.x;  // 수정된 부분: x, y를 현재 국가의 위치로 업데이트
            y = country.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                //다음 도시가 방문된 적 없고, NxN 범위 안에 있다면
                if(nx>=0 && nx<n && ny>=0 && ny<n){
                    //현재 도시와 다음 도시와 연결될 수 있다면
                    if(!visit[nx][ny] && l <= Math.abs(map[x][y] - map[nx][ny]) && r >= Math.abs(map[x][y] - map[nx][ny])){
                        isMove = true; //국경 이동이 있으면 계속 반복되게 만듬.
                        visit[nx][ny]=true;
                        unionCountry.add(new Country(nx, ny));
                        Q.add(new Country(nx, ny));
                    }
                }
            }
        }

        //연합을 이루고 있는 각 칸의 인구수 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)로 세팅
        int sum = 0;
        for(Country country : unionCountry){
            sum += map[country.x][country.y];
        }
        for(Country country : unionCountry){
            map[country.x][country.y] = sum / unionCountry.size();
        }
    }
}
