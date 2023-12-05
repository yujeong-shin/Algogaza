// 바이러스

import java.util.Scanner;

public class B_2606 {
	static int edge;
	static int vertex;
	static int start;
	static int[][] graph;
	static boolean[] visited;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		count = -1;
		vertex = sc.nextInt();
		edge = sc.nextInt();
		graph = new int[vertex + 1][vertex + 1];
		visited = new boolean[vertex + 1];

		for (int i = 0; i < edge; i++) {
			addEdge(sc.nextInt(), sc.nextInt());
		}
		dfs(1);
		System.out.print(count);

	}

	private static void addEdge(int i1, int i2) {
		graph[i1][i2] = 1;
		graph[i2][i1] = 1;
	}

	private static void dfs(int i) {
		visited[i] = true;
		count++;

		for (int j = 1; j < vertex + 1; j++) {
			if (graph[i][j] == 1 && !visited[j]) {
				dfs(j);
			}
		}
	}
}