import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex10974_모든순열 {
    static int[] num, combi;
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        //num = new int[n];
        combi = new int[n];
        visited = new boolean[n];

        DFS(0);
    }
    static void DFS(int L){
        if(L==n){
            for(int num : combi){
                System.out.print(num+ " ");
            }
            System.out.println();
        }
        else{
            for (int i = 0; i < n; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    combi[L] =i+1;
                    DFS(L+1);
                    visited[i] = false;
                }
            }
        }
    }
}
