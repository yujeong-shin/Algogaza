// 유기농 배추

import java.util.Scanner;

public class Main {
	static int[][] graph;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		result = new int[T];

		for (int t = 0; t < T; t++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int K = sc.nextInt();

			graph = new int[M][N];

			for (int i = 0; i < K; i++) {
				addCabbage(sc.nextInt(), sc.nextInt());
			}

			int wormCount = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (graph[i][j] == 1) {
						wormCount += dfs(i, j);
					}
				}
			}
			result[t] = wormCount;

		}
		for (int i = 0; i < T; i++) {
			System.out.println(result[i]);
		}

	}

	private static void addCabbage(int x, int y) {
		graph[x][y] = 1;
	}

	private static int dfs(int x, int y) {
		if (x < 0 || x >= graph.length || y < 0 || y >= graph[0].length || graph[x][y] == 0) {
			return 0;
		}

		graph[x][y] = 0;
		dfs(x - 1, y);
		dfs(x + 1, y);
		dfs(x, y - 1);
		dfs(x, y + 1);
		return 1;
	}
}