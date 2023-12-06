package HiJaeYoung.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Num1916 {
    static List<List<Node>> map;
    static class Node implements Comparable<Node>{
        int end;
        int value;
        public Node (int end,int value){
            this.end = end;
            this.value = value;
        }
        @Override
        public int compareTo(Node o){
            return this.value - o.value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(bf.readLine());
        int edge = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        map = new ArrayList<>();
        for(int i=0;i<=node;i++){
            map.add(new ArrayList<>());
        }
        for(int i=0 ;i<edge;i++){
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map.get(start).add(new Node(end,value));
        }
        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(Dijkstra(start,end,node));
    }
    public static int Dijkstra(int s,int e,int node){
        PriorityQueue<Node> qp = new PriorityQueue<>();
        int[] dis = new int [node+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        boolean[] vist = new boolean[node+1];
        dis[s] = 0;
        qp.add(new Node(s,0));
        while(!qp.isEmpty()){
            Node now = qp.poll();
            if(vist[now.end]){
                continue;
            }
            vist[now.end] =true;
            for(Node nxt : map.get(now.end)){
                if(dis[nxt.end] > dis[now.end]+nxt.value){
                    dis[nxt.end] = dis[now.end]+nxt.value;
                    qp.add(new Node(nxt.end,nxt.value+dis[now.end]));
                }
            }
        }
        return dis[e];
    }
}
