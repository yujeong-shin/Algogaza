import java.io.*;
import java.util.StringTokenizer;

public class Q15650 {
    static int N, M;
    static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[N];
        dfs(1,0);
    }
    private static void dfs(int n, int depth) throws IOException {
        if(depth == M){
            for(int i=0; i<depth; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=n; i<=N; i++){
            result[depth] = i;
            dfs(i+1,depth + 1);
        }
    }
}
