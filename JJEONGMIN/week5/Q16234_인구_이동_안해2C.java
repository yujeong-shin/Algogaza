import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BFS를 두 번 돌아야하나?
public class Q16234_인구_이동_안해2C {
    static int N,L,R, count = 0;
    static int[][] map;
    static boolean[][] visited;
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
        while(true){
            if(checkUnion(R-L)){
                count++;
            }
        }

    }
    private static boolean checkUnion(int diff){
        return false;
    }
    private static void bfs(){

    }
}

