import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14888_연산자_끼워넣기 {
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static List<Integer> numbers = new ArrayList<>();
    static List<Integer> operators = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            // 0 : 덧셈, 1 : 뺄셈, 2: 곱셈, 3: 나눗셈
            int operator = Integer.parseInt(st.nextToken());
            for (int j = 0; j < operator; j++) {
                operators.add(i);
            }
        }
        visited = new boolean[N - 1];
        List<Integer> temp = new ArrayList<>();
        dfs(0, temp);
        System.out.println(max + "\n" + min);
    }

    private static void dfs(int current, List<Integer> temp) {
        if (temp.size() == operators.size()) {
            solution(temp);
            return;
        }
        for (int i = 0; i < operators.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.add(operators.get(i));
                dfs(i, temp);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static void solution(List<Integer> temp) {
        int value = numbers.get(0);
        for (int i = 0; i < temp.size(); i++) {
            int operator = temp.get(i);
            if (operator == 0) {
                value += numbers.get(i + 1);
            } else if (operator == 1) {
                value -= numbers.get(i + 1);
            } else if (operator == 2) {
                value *= numbers.get(i + 1);
            } else if (operator == 3) {
                if (value < 0) {
                    value = (Math.abs(value) / numbers.get(i + 1)) * -1;
                } else {
                    value = value / numbers.get(i + 1);
                }
            }
        }
        max = Math.max(max, value);
        min = Math.min(min, value);
    }
}
