import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q6987_월드컵 {
    static int[][] country = new int[6][3];
    static boolean[] visited = new boolean[6];
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++){
                for(int k=0; k<3; k++){
                    country[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            answer = 0;
            Arrays.fill(visited, false);
            worldcup();
            sb.append(answer).append(" ");
        }
        System.out.println(sb.toString());
    }
    private static void worldcup(){


        for(int i=0; i<6; i++){
            if(!visited[i]){
                visited[i] = true;
            }
        }
    }
}
