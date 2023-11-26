import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ex2606 {
    static int N, E, count;
    static int[] ch;
    static int[][] graph;
    public static void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        ch[v]=1;
        Q.offer(v);

        while(!Q.isEmpty()) {
            int tmp = Q.poll();
            for(int j=0; j<N+1; j++) {
                if(graph[tmp][j]==1 && ch[j]==0) {
                    count++;
                    ch[j]=1;
                    Q.offer(j);
                }
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
        ex2606.BFS(1);
        System.out.println(count);
    }
}