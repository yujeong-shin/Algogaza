// 단지 번호 붙이기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B_2667 {
	static int[][] graph;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		graph = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] x = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(x[j]);
			}
		}

		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] == 1) {
					count++;
					list.add(dfs(i, j));
				}
			}
		}

		Collections.sort(list);
		System.out.println(count);
		for (int num : list) {
			System.out.println(num);
		}
	}

	private static int dfs(int x, int y) {
		if (x < 0 || x >= graph.length || y < 0 || y >= graph[0].length || graph[x][y] == 0) {
			return 0;
		}

		graph[x][y] = 0;

		int num = 1;
		num += dfs(x - 1, y);
		num += dfs(x + 1, y);
		num += dfs(x, y - 1);
		num += dfs(x, y + 1);

		return num;
	}
}