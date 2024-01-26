import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q15663_N과_M_9 {
    static List<Integer> numList = new ArrayList<>();
    static Set<List<Integer>> set = new LinkedHashSet<>();
    static boolean[] visited;
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

        visited = new boolean[numList.size()];
        backtracking(0, new ArrayList<>());

        System.out.println(sb.toString());
    }
    private static void backtracking(int count, List<Integer> temp){
        if(count == M){
            // 중복 값을 없애래 왜? 그냥 사이좋게 같이 뽑아주면 안되나,,,
            for(int i=0; i<M; i++){
                sb.append(temp.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }
        // 함수가 재귀할 때마다 초기화
        before = 0;
        for(int i=0; i<numList.size(); i++){
            if(!visited[i] && numList.get(i) != before){
                visited[i] = true;
                temp.add(numList.get(i));
                backtracking(count+1, temp);
                visited[i] = false;
                // 다음 반복문에 걸릴 수 있도록 before값 설정
                before = temp.remove(temp.size()-1);
            }
        }
    }
}
