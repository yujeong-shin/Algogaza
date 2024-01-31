import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex15657_N과M_8 {
    static StringBuilder sb = new StringBuilder();
    static int[] num, combi;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        combi = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        DFS(0, 0);
        System.out.println(sb);
    }
    static void DFS(int L, int start){
        if(L==m){
            for(int number : combi){
                sb.append(number).append(" ");
            }
            sb.append("\n");
        }
        else{
            for (int i = start; i < n; i++) {
                combi[L]=num[i];
                DFS(L+1, i);
            }
        }
    }
}
