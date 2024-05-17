package HiJaeYoung.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1504_targetShotCut {
    static int[] dist;
    static int N;
    private static class Node{
        int end;
        int value;
        Node(int end,int value){
            this.end = end;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sc = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(sc.nextToken());
        int E = Integer.parseInt(sc.nextToken());
        List<List<Node>> map = new ArrayList<>();
        for(int i=0;i<=N;i++){
            map.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            sc = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(sc.nextToken());
            int end = Integer.parseInt(sc.nextToken());
            int value = Integer.parseInt(sc.nextToken());
            map.get(start).add(new Node(end,value));
            map.get(end).add(new Node(start,value));
        }
        sc = new StringTokenizer(bf.readLine());
        int target1 = Integer.parseInt(sc.nextToken());
        int target2 = Integer.parseInt(sc.nextToken());
        int cost=0;
        for(Node now : map.get(target1)){
            if(now.end==target2){
                cost = now.value;
            }
        }
        int answer1 = cost;
        int answer2 = cost;

        // 1에서 targets 까지 최단 거리 계산
        dijkstra(map,1);
        answer1 = dist[target1];
        answer2 = dist[target2];

        // case 1
        dijkstra(map,target2);
        answer1 += dist[N];
        // case2
        dijkstra(map,target1);
        answer2 += dist[N];
        System.out.println(answer1+" "+answer2);

    }
    public static void dijkstra(List<List<Node>> map,int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o1.value-o2.value;
        });
        pq.add(new Node(1,0));
        dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;
        boolean[] vist = new boolean[N+1];
        while(!pq.isEmpty()){
            Node now = pq.poll();
            System.out.println(Arrays.toString(dist));
            System.out.println(now.value);
            if(vist[now.end]){
                continue;
            }
            vist[now.end] = true;
            for(Node nextNode : map.get(now.end)){
                if(dist[nextNode.end] > now.value+dist[now.end]){
                    dist[nextNode.end] = now.value+dist[now.end];
                    pq.add(new Node(nextNode.end,now.value+dist[now.end]));
                }
            }
        }
    }
}
