// 촌수계산

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2644 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); 
	static int vertex;
	static int a, b;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		vertex = Integer.parseInt(br.readLine());

		for (int i = 0; i <= vertex; i++) {
			graph.add(new ArrayList<>());
		}

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph.get(x).add(y); 
			graph.get(y).add(x);
		}

		visited = new boolean[vertex + 1];
		result = -1;

		dfs(a, 0);

		System.out.println(result);
	}

	static void dfs(int i, int count) {
		visited[i] = true;

		for (int j : graph.get(i)) {
			if (!visited[j]) {
				if (j == b) {
					result = count + 1;
				}
				dfs(j, count + 1); // 촌수 증가

			}
		}
	}
}