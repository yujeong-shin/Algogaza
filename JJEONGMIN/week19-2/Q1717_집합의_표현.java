import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

// a가 포함되어 있는 집합? b가 포함되어 있는 집합?
public class Q1717_집합의_표현 {
    static class Operator {
        int type;
        int a;
        int b;
        public Operator(int type, int a, int b){
            this.type = type;
            this.a = a;
            this.b = b;
        }
    }
    static Deque<Operator> deque = new LinkedList<>();
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        parent = IntStream.rangeClosed(0, N).toArray();
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            deque.offerLast(new Operator(type, a, b));
        }

        while(!deque.isEmpty()){
            Operator operator = deque.pollFirst();
            if(operator.type == 0){
                union(operator.a, operator.b);
            } else {
                if(isSameParent(operator.a, operator.b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
    public static int find(int x) {
        if(x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            if(a < b) parent[b] = a;
            else parent[a] = b;
        }
    }
    public static boolean isSameParent(int a, int b){
        a = find(a);
        b = find(b);
        return a == b;
    }
}
