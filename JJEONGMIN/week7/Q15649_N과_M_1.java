import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q15649_N과_M_1 {
    static List<Integer> list = new ArrayList<>();
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];

        dfs(N, M, 1, 0);
    }
    private static void dfs(int N, int M, int num, int count){
        if(count == M) {
            for(int i=0; i<M; i++){
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(i);
                dfs(N,M,num+1,count+1);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
