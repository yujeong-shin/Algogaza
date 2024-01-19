import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15654_N과_M_5 {
    static int a=0, b=0;
    static boolean[] visited;
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
        visited = new boolean[strArr.size()];

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

        for(int i=0; i<strArr.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                temp.add(strArr.get(i));
                dfs();
                visited[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
