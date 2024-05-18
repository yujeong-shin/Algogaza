import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Bus implements Comparable<Bus>{
    int index, dist;
    Bus(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }
    @Override
    public int compareTo(Bus o){
        return this.dist - o.dist;
    }
}

public class ex1916_최소비용구하기 {
    static int N, M;
    static ArrayList<ArrayList<Bus>> graph;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 도시의 갯수
        M = Integer.parseInt(br.readLine()); // 버스의 갯수
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[N+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 연결 정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Bus(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Dijkstra(S);
        System.out.println(dist[E]);
    }

    static void Dijkstra(int start) {
        PriorityQueue<Bus> pQ = new PriorityQueue<>();
        dist[start] = 0;
        pQ.add(new Bus(start, 0));

        while(!pQ.isEmpty()) {
            Bus now = pQ.poll();
            if(visited[now.index]) continue; // 이미 방문한 노드는 건너뛰기
            visited[now.index] = true;

            for(Bus next : graph.get(now.index)){
                if(!visited[next.index] && dist[next.index] > next.dist + dist[now.index]) {
                    dist[next.index] = next.dist + dist[now.index];
                    pQ.add(new Bus(next.index, dist[next.index]));
                }
            }
        }
    }
}
