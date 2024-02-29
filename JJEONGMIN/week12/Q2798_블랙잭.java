import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q2798_블랙잭 {
    static List<Integer> list = new ArrayList<>();
    static int M, result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        dfs(new ArrayList<>(), 0);
        System.out.println(result);
    }
    private static void dfs(List<Integer> temp, int num){
        if(temp.size() == 3){
            int sum = temp.get(0) + temp.get(1) + temp.get(2);
            if(sum <= M){
                result = Math.max(result, sum);
            }
            return;
        }
        for(int i=num; i<list.size(); i++){
            temp.add(list.get(i));
            dfs(temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
