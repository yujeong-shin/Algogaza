import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3584 {
    static int[][] treeArray;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            treeArray = new int[N+1][N+1];
            for(int i=0; i<N-1; i++){
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                treeArray[A][B] = treeArray[B][A] = 1;
            }
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            dfs(N,A,B);
        }
    }
    private static void dfs(int N, int A, int B){
        for(int i=1; i<N+1; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(N,A,B);
                visited[i] = false;
            }
        }
    }
}
