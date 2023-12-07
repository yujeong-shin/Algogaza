import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260_2 {
    static int N,M,V;
    static boolean[] visited;
    static int[][] treeArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        treeArray = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            treeArray[a][b] = treeArray[b][a] = 1;
        }

        dfs(V);
        System.out.println();

        Arrays.fill(visited, false);
        bfs(V);
    }
    private static void dfs(int v){
        visited[v] = true;
        System.out.print(v + " ");
        if(v == treeArray.length) return;
        for(int i=0; i<treeArray.length; i++){
            if(treeArray[v][i] == 1 && !visited[i])
                dfs(i);
        }
    }
    private static void bfs(int v){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(v);
        visited[v] = true;
        System.out.print(v + " ");

        while(!q.isEmpty()){
            int n = q.poll();

             for(int i = 1; i<treeArray.length; i++){
                 if(treeArray[n][i] == 1 && !visited[i]){
                     visited[i] = true;
                     System.out.print(i + " ");
                     q.offer(i);
                 }
             }
        }
    }
}
