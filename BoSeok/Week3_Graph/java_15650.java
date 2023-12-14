package BoSeok.Week3_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class java_15650 {
    static int n, m;
    static Stack<Integer> stack;
    public static void dfs(int depth) {
        if (stack.size() == m) { // 스택 m 길이 만큼 채우면
            for(int i : stack) // 스택 값들 뽑아주고
                System.out.print(i + " ");
            System.out.println();
            return; // 돌아감
        }
        for (int i = depth + 1; i < n + 1; i++) {
            stack.add(i); // 1을 넣으면 다음 숫자넣으러 dfs 출발
            dfs(i);
            stack.pop();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        stack = new Stack<>();
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        dfs(0);
    }
}
