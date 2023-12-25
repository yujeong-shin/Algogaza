package HiJaeYoung.Graph.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Num16928 {
    static int[] map;
    static boolean[] vist;
    private static class Node implements Comparable<Node>{
        int now;
        int count;
        Node(int now,int count){
            this.now = now;
            this.count = count;
        }
        @Override
        public int compareTo(Node o){
            if(this.count==o.count){
                return o.now-this.now;
            }
            return this.count - o.count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int labber = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());
        map = new int[101];
        vist = new boolean[101];
        for(int i=0;i<labber;i++){
            st = new StringTokenizer(bf.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<snake;i++){
            st = new StringTokenizer(bf.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        System.out.println(BFS());
    }
    public static int BFS(){
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(1,0));
        while(!que.isEmpty()){
            Node now = que.poll();
            if(vist[now.now]){
                continue; //^^
            }else{
                vist[now.now] =true;
            }
            //System.out.println(now.now);
            if(now.now==100){
                return now.count;
            }
            for(int i=1;i<=6;i++){
                if(now.now+i>100){
                    continue;
                }
                if(map[now.now+i] != 0 && !vist[map[now.now+i]]){
                    que.add(new Node(map[now.now+i], now.count+1));
                }else if(!vist[map[now.now+i]]){
                    que.add(new Node(now.now+i, now.count+1));
                }
            }
        }
        return 0;
    }
}
