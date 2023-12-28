import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// M: 총 사람(정점)의 수, A && B: 비교할 두 대상, N: 부모 자식간의 관계(간선 개수)
public class Q2644_촌수계산_오답 {
    static int M, A, B, result = 0;
    static int[][] treeArray;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(br.readLine());

        treeArray = new int[M+1][M+1];
        visited = new boolean[M+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int mom = Integer.parseInt(st.nextToken());
            int son = Integer.parseInt(st.nextToken());
            treeArray[mom][son] = treeArray[son][mom] = 1;
        }

        dfs(A);
        if(!visited[B]) result = -1;
        System.out.println(result);
    }

    private static void dfs(int V){
        visited[V] = true;
        if(V == B) {
            for(int i = 1; i < M+1; i++)
                visited[i] = true;
            return;
        }
        for(int i=1; i<M+1; i++){
            if(treeArray[V][i] == 1 && !visited[i]) {
                result++;
                dfs(i);
            }
            // 반례
            // 4
            // 1 4
            // 3
            // 1 2
            // 2 3
            // 2 4
            // 2에서 3으로 탐색 후 아래 else if조건이 충족하여 result가 0이됨 ㄹㅇ;
            else if(i == M && !visited[B]){
                result = 0;
                break;
            }
        }
    }
}

