import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13460_구슬_탈출_2 {
    static class Ball{
        int h;
        int w;
        boolean fall;
        Ball(int h, int w){
            this.h = h;
            this.w = w;
            this.fall = false;
        }
    }
    static char[][] map;
    static Ball redBall, blueBall, hole;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
                if(str.charAt(j) == 'R') redBall = new Ball(i,j);
                if(str.charAt(j) == 'B') blueBall = new Ball(i,j);
                if(str.charAt(j) == 'O') hole = new Ball(i,j);
            }
        }

    }
}
