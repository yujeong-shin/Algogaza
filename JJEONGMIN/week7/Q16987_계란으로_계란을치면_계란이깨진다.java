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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<eggMayo> eggMayoList = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            eggMayoList.add(
                    new eggMayo(
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken())
                    )
            );
        }

        dfs(eggMayoList, 0);
    }
    private static void dfs(List<eggMayo> eggMayoList, int count){

    }
}
