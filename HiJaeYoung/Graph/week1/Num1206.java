package HiJaeYoung.Graph.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Num1206 {
    static List<List<Integer>> map;
    static boolean[] vist;
    static StringBuilder sb;
    static int node;
    public static void DFS(int start){
        sb.append(start+" ");
        vist[start] = true;
        for(int end : map.get(start)){
            if(vist[end])
                continue;
            DFS(end);
        }
    }
    public static void BFS(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        vist[start] = true;
        sb.append(start+" ");
        while(!que.isEmpty()){
            int nowNode = que.poll();
            for(int next:map.get(nowNode)){
                if(!vist[next]){
                    sb.append(next+" ");
                    que.add(next);
                    vist[next] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();
        for(int i=0;i<=node; i++){
            map.add(new ArrayList<>());
        }
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(bf.readLine());
            int  startPoint = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.get(startPoint).add(end);
            map.get(end).add(startPoint);
        }
        vist = new boolean[node+1];
        Arrays.fill(vist,false);
        for(int i=0;i<=node;i++){
            Collections.sort(map.get(i));
        }
        sb =new StringBuilder();
        vist[start] = true;
        DFS(start);
        Arrays.fill(vist,false);
        sb.append("\n");
        BFS(start);
        System.out.println(sb);
    }
}