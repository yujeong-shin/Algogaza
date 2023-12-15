import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ex10026 {
    static List<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        answer = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][n];
        char[][] mapEqualRG = new char[n][n];
        for (int i = 0; i < n; i++) {
            String mapInput = bf.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = mapInput.charAt(j);
                //적록색약 초기화
                if(mapInput.charAt(j)=='G') {
                    mapEqualRG[i][j] = 'R';
                }
                else {
                    mapEqualRG[i][j] = mapInput.charAt(j);
                }
            }
        }
        
    }
    
    static void BFS(){
        //결과값을 answer List에 add

    }
}
