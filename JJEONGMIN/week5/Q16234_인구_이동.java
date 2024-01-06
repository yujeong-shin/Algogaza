import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16234_인구_이동 {
    static int N,L,R, answer = 0;
    static int[][] map;
    static boolean[][] visited;
    static boolean isMoved =false;
    static int[] dh = {-1,0,0,1};
    static int[] dw = {0,-1,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        while(true) {
            setVisitedToFalse();
            isMoved = false;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        bfs(new Point(i,j));
                    }
                }
            }
            if(!isMoved) break;
            answer++;
        }
        System.out.println(answer);
    }
    private static boolean checkUnion(int diff){
        return false;
    }
    private static void bfs(Point p) {
        int diff = 0;
        int temp = map[p.x][p.y];
        int unionCount = 1;

        Queue<Point> queue = new LinkedList<>();
        ArrayList<Point> moveList = new ArrayList<>();
        queue.offer(p);
        moveList.add(p);
        visited[p.x][p.y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextH = point.x + dh[i];
                int nextW = point.y + dw[i];

                if (nextH >= 0 && nextH < N && nextW >= 0 && nextW < N && !visited[nextH][nextW]) {
                    diff = Math.abs(map[point.x][point.y] - map[nextH][nextW]);
                    if (diff >= L && diff <= R) {
                        visited[nextH][nextW] = true;
                        queue.offer(new Point(nextH, nextW));
                        moveList.add(new Point(nextH,nextW));
                        temp += map[nextH][nextW];
                    }
                }
            }
        }
        if (moveList.size() > 1)
            move(temp, moveList);
    }
    private static void move(int temp, ArrayList<Point> moveList){
        int avg = temp / moveList.size();
        for(Point point : moveList){
            map[point.x][point.y] = avg;
        }
        isMoved = true;
        moveList.clear();
    }
    private  static void setVisitedToFalse(){
        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }
    }
}
