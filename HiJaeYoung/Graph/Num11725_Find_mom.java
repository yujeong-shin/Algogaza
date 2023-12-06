package HiJaeYoung.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num11725_Find_mom {
    static StringBuilder sb;
    static List<List<Integer>> map;
    static boolean[] vist;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int node = Integer.parseInt(bf.readLine());
        sb = new StringBuilder();
        vist = new boolean[node+1];
        answer = new int[node+1];;
        map = new ArrayList<>();
        for(int i=0;i<=node ;i++){
            map.add(new ArrayList<>());
        }
        // 양방향 그래프로 받아야 할까?
        // 4 1 (어 받아~)
        for(int i=1;i<node;i++){
            st = new StringTokenizer(bf.readLine());
            int right = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            map.get(right).add(left);
            map.get(left).add(right);
        }
        DFS(1,1);
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=node;i++){
            sb.append(answer[i]+"\n");
        }
        System.out.print(sb);
    }
    public static void DFS(int pre,int now){
        answer[now] = pre;
        vist[now] = true;
        for(int nxt : map.get(now)){
            if(vist[nxt]) continue;
            DFS(now,nxt);
        }
    }
}
