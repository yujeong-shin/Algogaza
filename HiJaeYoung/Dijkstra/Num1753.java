import java.io.*;
import java.util.*;

public class Num1753 {
    static List<List<Node>> map;
    public static class Node implements Comparable<Node>{
            int end;
            int value;
            public Node(int e, int v){
                this.end =e;
                this.value =v;
            }
            @Override
            public int compareTo(Node o){
                return this.value - o.value;
            }
}
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int startPoint = Integer.parseInt(bf.readLine());
        map = new ArrayList<>();
        for(int i=0; i<=v;i++){
            map.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            st = new StringTokenizer(bf.readLine());
            int start =Integer.parseInt(st.nextToken());
            int end =Integer.parseInt(st.nextToken());
            int value =Integer.parseInt(st.nextToken());
            map.get(start).add(new Node(end,value));
        }
        bf.close();
        int index =0;
        StringBuilder sb = new StringBuilder();
        for (int value :dijkstra(startPoint)){
            if(index>=1 && index<=v){
                if(value == Integer.MAX_VALUE){
                    sb.append("INF"+"\n");
                }else{
                    sb.append(value+"\n");
                }
            }
            index++;
        }
        System.out.println(sb.toString());
    }
    static public int[] dijkstra(int start){
        PriorityQueue pq = new PriorityQueue<Node>();
//        for(Node now : map.get(start)){
//            pq.add(now);
//        }
        pq.add(new Node(start,0));
        int []dis = new int[map.size()+1];
        boolean[] vist = new boolean[map.size()+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(vist, false);
        dis[start] =0;
        while(!pq.isEmpty()){
            Node now = (Node) pq.poll();
            if(vist[now.end]){
                continue;
            }
            vist[now.end] =true;
            for(Node nxt : map.get(now.end)){
                if(dis[now.end]+ nxt.value < dis[nxt.end]){
                    dis[nxt.end] = dis[now.end]+ nxt.value;
                    pq.add(new Node(nxt.end,dis[nxt.end]));
                }
            }
//            if(vist[now.start]) continue;
//            vist[now.start] =true;
//            for(Node nxt:map.get(now.end)){
//                if(dis[nxt.start]+nxt.value<dis[nxt.end]){
//                    dis[nxt.end] = dis[nxt.start]+nxt.value;
//                    pq.add(nxt);
//                }
//            }
//            if(now.value+dis[now.start]<dis[now.end]){
//                dis[now.end] = now.value+dis[now.start];
//                for(Node nxt : map.get(now.end)) {
//                    if(dis[nxt.end] >dis[nxt.start]){
//                        pq.add(nxt);
//                    }
//                }
//            }
        }
        return dis;
    }
}
