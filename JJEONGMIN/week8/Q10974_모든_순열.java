import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q10974_모든_순열 {
    static StringBuilder sb = new StringBuilder();
    static List<Integer> temp = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        dfs(N, 0);
        System.out.println(sb.toString());
    }
    private static void dfs(int N, int count){
        if(count == N){
            for(int i=0; i<temp.size(); i++){
                sb.append(temp.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                temp.add(i);
                dfs(N, count +1);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }
    }
}
