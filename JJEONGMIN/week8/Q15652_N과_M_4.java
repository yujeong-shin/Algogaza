import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15652_N과_M_4 {
    static int a=0, b=0;
    static List<Integer> temp = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        dfs(0, 1);
        System.out.println(sb.toString());
    }
    private static void dfs(int count,int num){
        if(count == b){
            for (Integer integer : temp) {
                sb.append(integer).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=num; i<=a; i++){
            temp.add(i);
            dfs(count+1, i);
            temp.remove(temp.size()-1);
        }
    }
}
