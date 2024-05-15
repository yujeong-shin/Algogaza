import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1389_케빈_베이컨 {
    static class Node{
        int num;
        int distance;
        public Node(int num, int distance){
            this.num = num;
            this.distance = distance;
        }
    }
    public static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            if(o1.distance == o2.distance) return o1.num - o2.num;
            return o1.distance - o2.distance;
        }
    }
    static int[][] map;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        Arrays.stream(map).forEach(row -> Arrays.fill(row, N));
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            map[A][B] = map[B][A] = 1;
        }
        init();
        System.out.println(count());
    }
    public static void init(){
        for(int m=1; m<=N; m++){
            for(int s=1; s<=N; s++){
                if(m == s) continue;
                for(int e=1; e<=N; e++){
                    if(s == e) continue;
                    if(map[s][e] > map[s][m] + map[m][e]) map[s][e] = map[s][m] + map[m][e];
                }
            }
        }
    }
    public static int count(){
        PriorityQueue<Node> nodes = new PriorityQueue<>(new NodeComparator());
        for(int i=1; i<=N; i++){
            int sum = 0;
            for(int j=1; j<=N; j++){
                sum += map[i][j];
            }
            nodes.offer(new Node(i, sum));
        }
        return nodes.poll().num;
    }
}
