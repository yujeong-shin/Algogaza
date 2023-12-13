import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q15650 {
    static int N,M;
    static List<List<Integer>> list;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];

        list = new ArrayList<>(N+1);
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        for(int i=1; i<=N; i++){
            for(int j=i+1; j<=N; j++){
                list.get(i).add(j);
            }
        }


        for(int i=1; i<N; i++){
            Arrays.fill(visited, false);
            dfs(i, sb);
        }
        bw.write(sb.toString());
        bw.flush();
    }
    private static void dfs(int n, StringBuilder sb){
        if(n == N) return;
        visited[n] = true;
        for(int i : list.get(n)){
            if(!visited[i])
                sb.append(i);
                dfs(i, sb);
        }
    }
}
