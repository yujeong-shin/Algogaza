import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q15666_N과_M_12 {
    static List<Integer> numList = new ArrayList<>();
    static int N = 0, M = 0, before = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(numList);

        backtracking(0,0, new ArrayList<>());

        System.out.println(sb.toString());
    }
    private static void backtracking(int num, int count, List<Integer> temp){
        if(count == M){
            for(int i=0; i<M; i++){
                sb.append(temp.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }
        before = 0;
        for(int i=num; i<numList.size(); i++){
            if(numList.get(i) != before){
                temp.add(numList.get(i));
                backtracking(i,count+1, temp);
                before = temp.remove(temp.size()-1);
            }
        }
    }
}
