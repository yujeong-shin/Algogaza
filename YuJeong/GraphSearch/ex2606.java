import java.util.Scanner;

public class ex2606 {
    static int N, E, count;
    static int[] ch;
    static int[][] graph;
    /*
    public static void DFS(int v) {
        for(int i=1; i<N+1; i++) {
            if(graph[v][i]==1 && ch[i]==0) {
                count++;
                ch[i]=1;
                DFS(i);
            }
        }
    }
     */

    public static void DFS(int v) {
        ch[v]=1;
        for(int i=1; i<N+1; i++) {
            if(graph[v][i]==1 && ch[i]==0) {
                count++;
                DFS(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new int[N+1][N+1];
        ch = new int[N+1];
        E = sc.nextInt();
        for(int i=0; i<E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph[s][e] = graph[e][s] = 1;
        }
        ex2606.DFS(1);
        System.out.println(count);
    }
}