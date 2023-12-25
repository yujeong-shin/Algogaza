import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q1759 {
    static int L,C;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String[] strArr = new String[C];
        List<String> temp = new ArrayList<>();
        visited = new boolean[C];
        for(int i=0; i<C; i++){
            strArr[i] = st.nextToken();
        }

        Arrays.sort(strArr);
        dfs(strArr, temp,0, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    private static void dfs(String[] strArr, List<String> temp, int count, int n){
        if(count == L){
            int cons = 0;
            int Vow = 0;
            for (String string : temp) {
                if (string.equals("a") || string.equals("e") || string.equals("i") || string.equals("o") || string.equals("u"))
                    Vow++;
            }
            cons = L - Vow;
            if(cons >= 2 && Vow >= 1){
                for (String s : temp) sb.append(s);
                sb.append("\n");
            }
                return;
        }
        for(int i=n; i<strArr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                temp.add(strArr[i]);
                dfs(strArr,temp, count+1, i+1);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }
    }
}
