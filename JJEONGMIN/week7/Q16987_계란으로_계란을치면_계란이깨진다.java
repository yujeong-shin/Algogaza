import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q16987_계란으로_계란을치면_계란이깨진다 {
    static class eggMayo {
        int durability;
        int weight;
        boolean boom;
        public eggMayo(int durability, int weight){
            this.durability = durability;
            this.weight = weight;
            this.boom = false;
        }
    }
    static List<eggMayo> eggMayoList = new ArrayList<>();
    static boolean[] visited;
    static int answer = 0, count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            eggMayoList.add(
                    new eggMayo(
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken())
                    )
            );
        }
        visited = new boolean[N];
        for(int i=0; i<eggMayoList.size(); i++){
            visited[i] = true;
            dfs(i, i+1);
        }

        System.out.println(answer);
    }
    private static void dfs(int current, int next){
        int boom_count = 0;
        for(eggMayo egg : eggMayoList){
            if(egg.boom) boom_count++;
            answer = Math.max(answer, boom_count);
        }
        if(next == eggMayoList.size()) return;
        if(eggMayoList.get(next).boom) return;

        for(int i=0; i<eggMayoList.size(); i++){
            if(i != current && !eggMayoList.get(i).boom && !visited[i]){
                visited[i] = true;
                eggMayoList.get(current).durability -= eggMayoList.get(i).weight;
                eggMayoList.get(i).durability -= eggMayoList.get(current).weight;
                if(eggMayoList.get(current).durability < 0) eggMayoList.get(current).boom = true;
                if(eggMayoList.get(i).durability < 0) eggMayoList.get(i).boom = true;
                dfs(current, i);
                visited[i] = false;
                eggMayoList.get(current).durability += eggMayoList.get(i).weight;
                eggMayoList.get(i).durability += eggMayoList.get(current).weight;
                if(eggMayoList.get(current).durability > 0) eggMayoList.get(current).boom = true;
                if(eggMayoList.get(i).durability > 0) eggMayoList.get(i).boom = false;
            }
        }
    }
}
