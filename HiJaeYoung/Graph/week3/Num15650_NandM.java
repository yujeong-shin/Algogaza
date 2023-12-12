package HiJaeYoung.Graph.week3;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Num15650_NandM {
    static int n,m;
    static StringBuilder sb;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        list = new ArrayList<>();
        bf.close();
        DFS(0,1);
        System.out.println(sb);
    }
    public static void DFS(int cnt, int start){
        if(cnt == m){
           for(int now : list){
               sb.append(now+" ");
           }
           sb.append("\n");
           return;
        }
        for(int i=start ;i<=n;i++){
            list.add(i);
            DFS(cnt+1,i+1);
            list.remove(list.size()-1);
        }
    }
}
