import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1916_최소비용_구하기_PQ사용 {
    static class Node{
        int end;
        int distance;
        public Node(int end, int distance){
            this.end = end;
            this.distance = distance;
        }
    }
    static int N, M;
    static List<List<Node>> nodeList = new ArrayList<>();
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i=0; i<=N; i++) nodeList.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            nodeList.get(start).add(new Node(end, distance));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(distance[end]);
    }
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.distance, o2.distance));
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();

            if(distance[curNode.end] < curNode.distance){
                continue;
            }
            for(int i=0; i<nodeList.get(curNode.end).size(); i++){
                Node nextNode = nodeList.get(curNode.end).get(i);
                if(distance[nextNode.end] > curNode.distance + nextNode.distance){
                    distance[nextNode.end] = curNode.distance + nextNode.distance;
                    pq.offer(new Node(nextNode.end, distance[nextNode.end]));
                }
            }
        }
    }
}
