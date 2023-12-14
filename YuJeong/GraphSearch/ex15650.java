import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex15650 {
    static int N, M;
    static int[] combi;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        combi = new int[M];
        DFS(0, 1);
    }
    public static void DFS(int L, int start){
        if(L==M) {
            for(int num : combi) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        else {
            for (int i = start; i <= N; i++) {
                combi[L]=i;
                DFS(L+1, i+1);
            }
        }
    }
}
