import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14888_연산자_끼워넣기 {
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();
    static int[] operators = new int[4];
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            // 0 : 덧셈, 1 : 뺄셈, 2: 곱셈, 3: 나눗셈
            operators[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[4][N];
        dfs(1, list.get(0));
        System.out.println(max + "\n" + min);
    }
    private static void dfs(int current, int value){
        if(checkOperators()) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        int bfValue = value;
        for(int i=current; i<list.size(); i++){
            int operator = selectOperator(i);
            if(operator == 0 && !visited[0][i]){
                visited[0][i] = true;
                value += list.get(i);
            } else if(operator == 1 && !visited[1][i]){
                visited[1][i] = true;
                value -= list.get(i);
            } else if(operator == 2 && !visited[2][i]){
                visited[2][i] = true;
                value *= list.get(i);
            } else if(operator == 3 && !visited[3][i]){
                visited[3][i] = true;
                if(value < 0) {
                    value = (Math.abs(value) % list.get(i)) * -1;
                } else {
                    value = value % list.get(i);
                }
            }
            dfs(i+1, value);
            operators[operator]++;
            value = bfValue;
        }
    }

    private static int selectOperator(int idx){
        for(int i=0; i<4; i++){
            if(visited[i][idx]) continue;
            if(operators[i] > 0) {
                operators[i]--;
                return i;
            }
        }
        return 4;
    }
    private static boolean checkOperators(){
        for(int i=0; i<4; i++){
            if(operators[i] != 0) return false;
        }
        return true;
    }
}
