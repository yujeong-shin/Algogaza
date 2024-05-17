import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14503_로봇_청소기 {
    static class Robot{
        int curH;
        int curW;
        int count;
        int direction;
        private Robot(){};
        public void setting(int curH, int curW, int direction){
            this.curH = curH;
            this.curW = curW;
            this.direction = direction;
        }
        public void plusCount(){
            this.count++;
        }
        public void setDirection(int direction){
            this.direction = direction;
        }
        public void movingBack(){
            int[] dh = {1, 0, -1, 0};
            int[] dw = {0, -1, 0, 1};
            robot.setting(this.curH + dh[this.direction], this.curW + dw[this.direction], this.direction);
        }
        public void movingFront(){
            int[] dh = {-1, 0, 1, 0};
            int[] dw = {0, 1, 0, -1};
            robot.setting(this.curH + dh[this.direction], this.curW + dw[this.direction], this.direction);
        }
    }
    static int[][] map;
    static boolean[][] visited;
    static Robot robot = new Robot();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        st = new StringTokenizer(br.readLine());

        robot.setting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            if(!visited[robot.curH][robot.curW]){
                visited[robot.curH][robot.curW] = true;
                robot.plusCount();
            }
            if(!checkBlank(robot.direction)){
                if(checkWall()) break;
                else robot.movingBack();
            }
        }
        System.out.println(robot.count);
    }
    public static boolean checkWall(){
        int[] dh = {1, 0, -1, 0};
        int[] dw = {0, -1, 0, 1};
        for(int i=0; i<4; i++){
            int nextH = robot.curH + dh[robot.direction];
            int nextW = robot.curW + dw[robot.direction];
            if(nextH < 0 || nextW < 0 || nextH >= map.length || nextW >= map[0].length || map[nextH][nextW] == 0) continue;
            if(map[nextH][nextW] == 1) return true;
        }
        return false;
    }
    public static boolean checkBlank(int direction){
        int[] dh = {-1, 0, 1, 0};
        int[] dw = {0, 1, 0, -1};
        for(int i=0; i<4; i++){
            direction--;
            if(direction == -1) direction = 3;
            int nextH = robot.curH + dh[direction];
            int nextW = robot.curW + dw[direction];
            if(nextH < 0 || nextW < 0 || nextH >= map.length || nextW >= map[0].length) continue;
            if(!visited[nextH][nextW] && map[nextH][nextW] == 0) {
                robot.setting(nextH, nextW, direction);
                return true;
            }
        }
        return false;
    }
}
