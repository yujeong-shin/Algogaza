import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex15652_N과M_4 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] combi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        combi = new int[m];

        DFS(0, 1);
        System.out.println(sb);
    }
    static void DFS(int L, int start){
        if(L==m){
            for(int num : combi){
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        else {
            for (int i = start; i <= n; i++) {
                combi[L] = i;
                DFS(L+1, i);
            }
        }
    }
}
