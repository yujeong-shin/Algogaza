package HiJaeYoung.Graph.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num11724_jaeyoung {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        List<List<Integer>> map = new LinkedList<>();
        for(int i=0;i<=node;i++){
            map.add(new ArrayList<>());
        }
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(bf.readLine());
            int right = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            map.get(right).add(left);
            map.get(left).add(right);
        }
        //System.out.println(map.get(1).toString());
        System.out.println(sol(map,node));
    }
    public static int sol(List<List<Integer>> map,int node){
        int answer =0;
        boolean[] vist = new boolean[node+1];
        for(int i=1;i<=node;i++){
            if(!vist[i]){
                BFS(map,i,vist);
                answer++;
            }
        }
        return answer;
    }
    public static void BFS(List<List<Integer>> map,int start,boolean[] vist){
        //System.out.println(start);
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        vist[start] = true;
        while(!que.isEmpty()){
            int now = que.poll();
            for(int nxt : map.get(now)){
                if(!vist[nxt]){
                    que.add(nxt);
                    vist[nxt] = true;
                }
            }
        }
    }
}
