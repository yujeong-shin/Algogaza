import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class City implements Comparable<City>{
    int index, dist;
    City(int index, int count){
        this.index = index;
        this.dist = count;
    }
    @Override
    public int compareTo(City o) {
        return this.dist - o.dist;
    }
}
public class ex18352_특정거리의도시찾기 {
    static int N, M, K, X;
    static ArrayList<City>[] arr;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시의 갯수
        M = Integer.parseInt(st.nextToken()); // 도로의 갯수
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호
        arr = new ArrayList[N+1];
        for (int i = 0; i <= N; i++){
            arr[i] = new ArrayList<>();
        }
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 연결 정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(new City(b, 1));
        }
        BFS(X);

        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                // StringBuilder 쓸까말까...
                System.out.println(i);
                flag = true;
            }
        }
        if (!flag)
            System.out.println(-1);
    }
    static void BFS(int start) {
        PriorityQueue<City> pQ = new PriorityQueue<>();
        pQ.add(new City(start, 0));
        // dist를 모두 MAX_VALUE로 초기화 했다가, start 지점을 0으로 두고 시작하는 게 포인트인 것 같다.
        dist[start] = 0;
        boolean[] visited = new boolean[N+1];

        while(!pQ.isEmpty()) {
            City cur = pQ.poll();
            visited[cur.index] = true;
            for(City next : arr[cur.index]) {
                if(!visited[next.index]) {
                    if(dist[next.index] > dist[cur.index] + next.dist) {
                        dist[next.index] = dist[cur.index] + next.dist;
                        pQ.add(new City(next.index, dist[next.index]));
                    }
                }
            }
        }
    }
}
