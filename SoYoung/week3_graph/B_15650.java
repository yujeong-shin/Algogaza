// N과 M (2)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_15650 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();

		dfs(n, m, 1, stack);

	}

	private static void dfs(int n, int m, int start, Stack<Integer> stack) {
		if (stack.size() == m) { 
			for (int num : stack) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= n; i++) {
			stack.push(i);
			dfs(n, m, i + 1, stack);
			stack.pop();

		}
	}

}