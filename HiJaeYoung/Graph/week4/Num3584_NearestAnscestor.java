package HiJaeYoung.Graph.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Num3584_NearestAnscestor {
    static int[] graph;
    static StringBuilder answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        answer = new StringBuilder();
        for(int i=0;i<testCase;i++){
            int n = Integer.parseInt(bf.readLine());
            graph = new int[n+1];
            for(int j=1;j<n;j++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int parent =Integer.parseInt(st.nextToken());
                int son = Integer.parseInt(st.nextToken());
                graph[son]=(parent);
            }
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int target1 = Integer.parseInt(st.nextToken());
            int target2 = Integer.parseInt(st.nextToken());
            int[] checkAncestor = new int[n+1];
            DFS(target1,checkAncestor);
            DFS(target2,checkAncestor);
        }
        System.out.print(answer);
    }
    public static void DFS(int start, int[] check){
        if(start ==0){
            return;
        }
        if(check[start]!=0){
            answer.append(start+"\n");
            return;
        }
        if(graph[start]==0){
            check[start] = start;
        }else{
            check[start] = graph[start];
        }
        DFS(graph[start],check);
    }
}
