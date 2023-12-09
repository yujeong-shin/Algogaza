import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex11724 {
    static int N, M, count=0;
    static List<List<Integer>> graph;
    static int[] ch;

    public static void main(String[] args) throws IOException {
        // 한 줄 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 한 줄 안에서 공백 기준으로 자르기
        StringTokenizer stk = new StringTokenizer(br.readLine());

        // 자른거 하나씩 저장
        N = Integer.parseInt(stk.nextToken()); //정점의 개수
        M = Integer.parseInt(stk.nextToken()); //간선의 개수

        graph = new LinkedList<>();
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int answer=0;
        ch = new int[N+1];
        for(int i=1;i<=N;i++){
            if(ch[i]==0){
                ch[i]=1;
                answer++;
                BFS(i);
            }
        }

        System.out.println(answer);
    }
    public static void BFS(int v){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(v);
        while(!Q.isEmpty()) {
            int cv = Q.poll();
            for(int nv : graph.get(cv)) {
                if(ch[nv]==0) {
                    ch[nv]=1;
                    Q.add(nv);
                }
            }
        }
    }
}