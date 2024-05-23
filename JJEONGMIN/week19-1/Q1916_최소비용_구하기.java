import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1916_최소비용_구하기 {
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
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
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

        distance[start] = 0;
        visited[start] = true;
        dijkstra(start);
        System.out.println(distance[end]);
    }
    public static void dijkstra(int start){
        for(int i=0; i<N; i++){
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = start;
            for(int j=1; j<=N; j++){
                if(!visited[j] && distance[j] < nodeValue){
                    nodeValue = distance[j];
                    nodeIdx = j;
                }
            }
            visited[nodeIdx] = true;

            for(int j=0; j<nodeList.get(nodeIdx).size(); j++){
                Node node = nodeList.get(nodeIdx).get(j);
                if(distance[node.end] > distance[nodeIdx] + node.distance){
                    distance[node.end] = distance[nodeIdx] + node.distance;
                }
            }
        }
    }
}
