import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ex5568_카드놓기 {
    static int n, k, answer;
    static int[] arr, combi;
    static boolean[] visited;
    static Map<Integer, Boolean> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        combi = new int[k];
        visited = new boolean[n];
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        DFS(0);
        System.out.println(answer);
    }

    static void DFS(int L){
        if(L==k){
            //sequence에 있는 숫자들을 붙여 Map에 key 값으로 없다면 answer++
            String ansStr = "";
            for (int i = 0; i < k; i++) {
                ansStr += combi[i];
            }
            int ans = Integer.parseInt(ansStr);
            if(!map.containsKey(ans)){
                map.put(ans, true);
                answer++;
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    combi[L] = arr[i];
                    DFS(L+1);
                    visited[i] = false;
                }
            }
        }
    }
}
