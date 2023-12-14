import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ex11725 {
    static List<List<Integer>> map;
    static boolean[] visit;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int node = Integer.parseInt(bf.readLine());
        visit = new boolean[node+1];
        parent = new int[node+1];;
        map = new ArrayList<>();
        for(int i=0; i<=node ;i++){
            map.add(new ArrayList<>());
        }
        for(int i=1; i<node; i++){
            st = new StringTokenizer(bf.readLine());
            int ver1 = Integer.parseInt(st.nextToken());
            int ver2 = Integer.parseInt(st.nextToken());
            map.get(ver1).add(ver2);
            map.get(ver2).add(ver1);
        }
        DFS(1);
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }
    public static void DFS(int cv){
        visit[cv] = true;
        for(int nv : map.get(cv)) {
            if(!visit[nv]) {
                parent[nv]=cv;
                DFS(nv);
            }
        }
    }
}
