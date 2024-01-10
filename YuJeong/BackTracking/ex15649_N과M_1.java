import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex15649_N과M_1 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N+1];

        DFS(0);
    }

    static void DFS(int L){
        if(L==M) {
            for(int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        else {
            for (int i = 1; i <= N; i++) {
                if(!visited[i]){
                    visited[i]=true;
                    arr[L] = i;
                    DFS(L+1);
                    visited[i]=false;
                }
            }
        }
    }
}
