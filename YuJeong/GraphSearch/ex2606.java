import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ex2606 {
    static int N, E, count;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;
    public static void BFS(int v){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        while(!Q.isEmpty()) {
            int cv = Q.poll();
            for(int nv : graph.get(cv)) {
                if(ch[nv]==0) {
                    ch[nv]=1;
                    count++;
                    Q.offer(nv);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }
        ch = new int[N+1];
        E = sc.nextInt();
        for(int i=0; i<E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        ch[1]=1;
        ex2606.BFS(1);
        System.out.println(count);
    }
}