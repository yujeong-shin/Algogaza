import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex10026 {
    static int[] dx={-1, 0, 1, 0}, dy={0, 1, 0, -1};
    static List<Integer> answers;
    static boolean visited[][];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        answers = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][n];
        char[][] mapConsistOfRB = new char[n][n];
        for (int i = 0; i < n; i++) {
            String mapInput = bf.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = mapInput.charAt(j);
                //적록색약 초기화
                //G를 모두 R로 세팅 => map에 R과 B만 존재
                if(mapInput.charAt(j)=='G') {
                    mapConsistOfRB[i][j] = 'R';
                }
                else {
                    mapConsistOfRB[i][j] = mapInput.charAt(j);
                }
            }
        }
        countOfZone(map);
        countOfZone(mapConsistOfRB);
        for(int answer : answers) System.out.print(answer + " ");
    }
    
    static void countOfZone(char[][] paint){
        //결과값을 answer List에 add
        int count=0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    count++;
                    BFS(paint, i, j);
                }
            }
        }
        answers.add(count);
    }

    static void BFS(char[][] paint, int x, int y){
        visited[x][y]=true;
        char nowColor = paint[x][y];
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(x, y));
        while (!Q.isEmpty()){
            Point now = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny] && paint[nx][ny]==nowColor){
                    visited[nx][ny]=true;
                    Q.add(new Point(nx, ny));
                }
            }
        }
    }
}
