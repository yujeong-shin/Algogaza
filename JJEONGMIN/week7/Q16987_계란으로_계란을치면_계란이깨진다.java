import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q16987_계란으로_계란을치면_계란이깨진다 {
    static class eggMayo {
        int durability;
        int weight;
        public eggMayo(int durability, int weight){
            this.durability = durability;
            this.weight = weight;
        }
    }
    static List<eggMayo> eggMayoList = new ArrayList<>();
    static int answer = 0;
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
        dfs(0, 0);

        System.out.println(answer);
    }
    private static void dfs(int current, int count){
        if(current == eggMayoList.size()){
            answer = Math.max(answer, count);
            return;
        }
        if(eggMayoList.get(current).durability<=0 || count == eggMayoList.size()-1){
            dfs(current+1, count);
            return;
        }

        int bfCount = count;
        for(int i=0; i<eggMayoList.size(); i++){
            if(i == current) continue;
            if(eggMayoList.get(i).durability<=0) continue;

            eggMayoList.get(current).durability -= eggMayoList.get(i).weight;
            eggMayoList.get(i).durability -= eggMayoList.get(current).weight;
            if(eggMayoList.get(current).durability <= 0) count++;
            if(eggMayoList.get(i).durability <= 0) count++;
            dfs(current+1, count);
            eggMayoList.get(current).durability += eggMayoList.get(i).weight;
            eggMayoList.get(i).durability += eggMayoList.get(current).weight;
            count = bfCount;
        }
    }
}

