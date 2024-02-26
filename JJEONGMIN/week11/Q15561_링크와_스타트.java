import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q15561_링크와_스타트 {
    static int[][] map;
    static List<Integer> team1 = new ArrayList<>();
    static List<Integer> team2 = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static int N;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        selectPlayer();

        System.out.println(result);
    }
    private static void selectPlayer(){
        if(team1.size() >= 2 && team2.size() >= 2){
            checkdiff(team1, team2);
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i] && team1.size() < 2){
                visited[i] = true;
                team1.add(i);
                selectPlayer();
                team1.remove(team1.size()-1);
                visited[i] = false;
            }
            else if(!visited[i] && team1.size() == 2){
                visited[i] = true;
                team2.add(i);
                selectPlayer();
                team2.remove(team2.size()-1);
                visited[i] = false;
            }
        }
    }
    private static void checkdiff(List<Integer> team1, List<Integer> team2){
        int diff1 = map[team1.get(0)][team1.get(1)] + map[team1.get(1)][team1.get(0)];
        int diff2 = map[team2.get(0)][team2.get(1)] + map[team2.get(1)][team2.get(0)];

        result = Math.min(Math.abs(diff1-diff2), result);
    }
}
