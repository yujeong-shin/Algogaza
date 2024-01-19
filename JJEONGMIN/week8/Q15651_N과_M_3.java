import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15651_N과_M_3 {
    static int a=0, b=0;
    static List<Integer> temp = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        dfs();
        System.out.println(sb.toString());
    }
    private static void dfs(){
        if(temp.size() == b) {
            for(int i=0; i<temp.size(); i++){
                sb.append(temp.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=a; i++){
            temp.add(i);
            dfs();
            temp.remove(temp.size()-1);
        }
    }
}
