import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3980_선발_명단 {
    static int[][] map = new int[11][11];
    static boolean[] position = new boolean[11];
    static boolean[] player = new boolean[11];
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            for(int i=0; i<11; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<11; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            answer = 0;
            dfs(0, 0);
            sb.append(answer);
            if(T > 0) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void dfs(int current, int sum){
        if(current == 11 && checkPositionAndPlayer()){
            answer = Math.max(answer, sum);
            return;
        }
        for(int i=current; i<11; i++){
            if(!position[i]){
                for(int j=0; j<11; j++){
                    if(map[i][j] == 0) continue;
                    if(!player[j]){
                        position[i] = true;
                        player[j] = true;
                        sum += map[i][j];
                            dfs(i+1, sum);
                        player[j] = false;
                        position[i] = false;
                        sum -= map[i][j];
                    }
                }
            }
        }
    }
    private static boolean checkPositionAndPlayer() {
        for(int i=0; i<11; i++){
            if(!position[i]) return false;
            if(!player[i]) return false;
        }
        return true;
    }
}
