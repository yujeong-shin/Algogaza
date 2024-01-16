import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2933_미네랄 {
    static int H,W;
    static char[][] map;
    static int[] stick;
    static boolean left = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0; j<W; j++){
                map[i][j] = str.charAt(j);
            }
        }
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        stick = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            stick[i] = Integer.parseInt(st.nextToken());
        }

        for(int h : stick){
            left = !left;
        }
    }
}
