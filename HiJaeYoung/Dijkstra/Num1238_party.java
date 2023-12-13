package HiJaeYoung.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1238_party {
    private static class Node implements Comparable<Node>{
        int end;
        int cost;
        Node(int end,int cost){
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return this.cost -o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        int node = Integer.parseInt(inputs[0]);
        int edge = Integer.parseInt(inputs[1]);
        int target = Integer.parseInt(inputs[2]);
        List<List<Node>> map = new LinkedList<>();
        for(int i=0;i<=node;i++){
            map.add(new ArrayList<>());
        }
        for(int i=0;i<edge;i++){
            inputs = bf.readLine().split(" ");
            map.get(Integer.parseInt(inputs[0])).add(new Node(Integer.parseInt(inputs[1]),Integer.parseInt(inputs[2])));
        }
        bf.close();
        int answer =Integer.MIN_VALUE;
        int[] costTOHOme = Arrays.copyOf(Dijkstra(map,node,target),node+1);
        System.out.println(Arrays.toString(costTOHOme));
        for(int i=1;i<=node;i++){
            if(i==target){
                continue;
            }
            int[] nowDis = Arrays.copyOf(Dijkstra(map,node,i),node+1);
            System.out.println(Arrays.toString(nowDis));
            answer = Math.max(answer,costTOHOme[i]+nowDis[target]);
        }
        System.out.println(answer);

    }
    public static int[] Dijkstra(List<List<Node>> map, int node,int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[node+1];
        boolean[] vist = new boolean[node+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(vist[now.end]){
                continue;
            }
            vist[now.end] = true;
            for(Node nxt : map.get(now.end)){
                if(dist[nxt.end]>dist[now.end]+nxt.cost){
                    dist[nxt.end]=dist[now.end]+nxt.cost;
                    pq.add(new Node(nxt.end,dist[now.end]+nxt.cost));
                }
            }
        }
        return dist;
    }
}
