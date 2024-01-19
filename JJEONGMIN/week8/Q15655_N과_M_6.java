import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15655_N과_M_6 {
    static int a=0, b=0;
    static List<Integer> temp = new ArrayList<>();
    static List<Integer> strArr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int size = st.countTokens();
        for(int i=0; i<size; i++){
            strArr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(strArr);

        dfs(0);
        System.out.println(sb.toString());
    }
    private static void dfs(int index){
        if(temp.size() == b) {
            for (Integer integer : temp) {
                sb.append(integer).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=index; i<strArr.size(); i++){
                temp.add(strArr.get(i));
                dfs(i+1);
                temp.remove(temp.size()-1);
        }
    }
}
