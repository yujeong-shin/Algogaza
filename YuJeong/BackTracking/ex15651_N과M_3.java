import java.io.*;
import java.util.StringTokenizer;

public class ex15651_N과M_3 {
    static int n, m;
    static int[] combi;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        combi = new int[m];

        DFS(0);
        System.out.println(sb);
    }

    static void DFS(int L) throws IOException {
        if(L==m){
            for(int num : combi){
                //sb에 모든 정답을 담아 한 번에 출력
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        else {
            for (int i = 0; i < n; i++) {
                combi[L] = i+1;
                DFS(L+1);
            }
        }
    }
}