import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q15664_N과_M_10 {
    static int N = 0, M = 0, before = 0;
    static List<Integer> numList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(numList);

        visited = new boolean[N];
        backTracking(0, new ArrayList<>());
        System.out.println(sb.toString());
    }
    private static void backTracking(int num, List<Integer> temp){
        if(temp.size() == M){
            for(int i=0; i<M; i++){
                sb.append(temp.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        before = 0;
        for(int i=num; i<N; i++){
            if(!visited[i] && numList.get(i) != before){
                visited[i] = true;
                temp.add(numList.get(i));
                backTracking(i+1, temp);
                visited[i] = false;
                before = temp.remove(temp.size()-1);
            }
        }
    }
}
