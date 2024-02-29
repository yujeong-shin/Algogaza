import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Q15561_링크와_스타트 {
    static int[][] map;
    static Map<Point, Integer> scoreMap = new HashMap<>();
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
//                map[i][j] = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                if(i == j) continue;
                if(i < j) scoreMap.put(new Point(i, j), score);
                else scoreMap.put(new Point(j, i), score + scoreMap.getOrDefault(new Point(j, i), 0));
            }
        }
        for(int i=2; i<=N/2; i++){
            selectPlayer(i, 0);
        }

        System.out.println(result);
    }
    private static void selectPlayer(int team1Count, int num){
        if(team1.size() == team1Count) {
            for(int i=0; i<N; i++){
                if(!visited[i]) team2.add(i);
            }
            checkdiff(team1, team2);
            team2.clear();
            return;
        }
        for(int i=num; i<N; i++){
            if(!visited[i] && team1.size() < team1Count){
                visited[i] = true;
                team1.add(i);
                selectPlayer(team1Count, i + 1);
                team1.remove(team1.size()-1);
                visited[i] = false;
            }
        }
    }
    private static void checkdiff(List<Integer> team1, List<Integer> team2){
        int stat1 = 0, stat2 = 0;
        for(int i=0; i<team1.size()-1; i++){
            for(int j=i+1; j<team1.size(); j++){
                stat1 += scoreMap.get(new Point(team1.get(i), team1.get(j)));
            }
        }
        for(int i=0; i<team2.size()-1; i++){
            for(int j=i+1; j<team2.size(); j++){
                stat2 += scoreMap.get(new Point(team2.get(i), team2.get(j)));
            }
        }
        result = Math.min(Math.abs(stat1-stat2), result);
    }
}
