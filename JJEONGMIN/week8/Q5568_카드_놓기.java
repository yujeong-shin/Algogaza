import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q5568_카드_놓기 {
    static int N, K;
    static List<String> strList = new ArrayList<>();
    static Set<String> strSet = new HashSet<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            strList.add(br.readLine());
        }
        visited = new boolean[N];
        dfs(0, new ArrayList<>());
        System.out.println(strSet.size());
    }
    private static void dfs(int count, List<String> temp){
        if(count == K) {
            String str = "";
            for(int i=0; i<K; i++){
                str += temp.get(i);
            }
            strSet.add(str);
            return;
        }

        for(int i=0; i<strList.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                temp.add(strList.get(i));
                dfs(count + 1, temp);
                visited[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
