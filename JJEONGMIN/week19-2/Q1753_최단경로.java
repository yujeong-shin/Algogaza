import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Q1753_최단경로 {
    static class Node{
        int end;
        int cost;
        public Node(int end, int cost){
           this.end = end;
           this.cost = cost;
        }
    }
    static List<List<Node>> nodeList = new ArrayList<>();
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        for(int i=0; i<=V; i++) nodeList.add(new ArrayList<>());
        distance = new int[V+1];
        int E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodeList.get(s).add(new Node(e, c));
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        dijkstra(start);
        IntStream.range(1, V+1).forEach(i -> {
            if(distance[i]== Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(distance[i]);
        });
    }
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            if(distance[curNode.end] < curNode.cost){
                continue;
            }
            for(int i=0; i<nodeList.get(curNode.end).size(); i++){
                Node nxtNode = nodeList.get(curNode.end).get(i);
                if(distance[nxtNode.end] > curNode.cost + nxtNode.cost){
                    distance[nxtNode.end] = curNode.cost + nxtNode.cost;
                    pq.offer(new Node(nxtNode.end, distance[nxtNode.end]));
                }
            }
        }
    }
}
