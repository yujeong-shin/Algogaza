import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1941_소문난_칠공주 {
    public static class Princess{
        Point point;
    }
    static char[][] map = new char[5][5];
    static int[] dh = {-1,0,0,1};
    static int[] dw = {0,-1,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<5; i++){
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = str.charAt(j);
            }
        }

    }
}
