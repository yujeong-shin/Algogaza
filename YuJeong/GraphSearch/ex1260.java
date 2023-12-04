import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ex1260 {
    static int N, M, V;
    static int[][] graph;
    static int[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        graph = new int[N+1][N+1];
        ch = new int[N+1];
        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = graph[b][a] = 1;
        }
        ex1260.DFS(V);
        System.out.println();
        ex1260.BFS(V);
    }

    public static void DFS(int v) {
        ch[v]=1;
        System.out.print(v + " ");
        for (int i = 1; i < N+1; i++) {
            if(graph[v][i]==1 && ch[i]==0) {
                ch[i]=1;
                DFS(i);
            }
        }
    }

    public static void BFS(int v) {
        Arrays.fill(ch, 0);
        Queue<Integer> Q = new LinkedList<>();
        ch[v]=1;
        Q.offer(v);
        while(!Q.isEmpty()) {
            int cv = Q.poll();
            System.out.print(cv + " ");
            for (int i = 1; i < N+1; i++) {
                if(graph[cv][i]==1 && ch[i]==0) {
                    ch[i]=1;
                    Q.offer(i);
                }
            }
        }
    }
}
