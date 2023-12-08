package HiJaeYoung.Graph.week2;

// int를 리턴 값으로 BFS 후 -1리턴
// node에 cnt 가 필요

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Num2644_calculateFamily{
    static List<List<Node>> map;
    static class Node{
        int end;
        int cnt;
        Node(int end,int cnt){
            this.end = end;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int numberOfNode = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        int targetA = Integer.parseInt(st.nextToken());
        int targetB = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(bf.readLine());
        map = new ArrayList<>();
        for(int i=0;i<=numberOfNode;i++){
            map.add(new ArrayList<>());
        }
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(bf.readLine());
            int numberA = Integer.parseInt(st.nextToken());
            int numberB = Integer.parseInt(st.nextToken());
            map.get(numberA).add(new Node(numberB,0));
            map.get(numberB).add(new Node(numberA,0));
        }
        System.out.println(BFS(map,numberOfNode,targetA,targetB));
    }
    public static  int BFS(List<List<Node>> map, int size, int start,int goal){
        Queue<Node> que = new LinkedList<>();
        boolean[] vist = new boolean[size+1];
        que.add(new Node(start,0));
        while (!que.isEmpty()){
            Node now = que.poll();
            if(now.end == goal){
                return now.cnt;
            }
            vist[now.end] = true;
            for(Node nxt : map.get(now.end)){
                if(!vist[nxt.end]){
                    que.add(new Node(nxt.end,now.cnt+1));
                }
            }
        }
        return -1;
    }
}
