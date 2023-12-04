// 연결 요소의 개수

import java.util.Scanner;

public class Main {
	static int[][] graph;
	static int vertex;
    static int edge;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		vertex = sc.nextInt();
		edge = sc.nextInt();
		graph = new int[vertex + 1][vertex + 1];
		visited = new boolean[vertex + 1];

		for (int i = 0; i < edge; i++) {
			addEdge(sc.nextInt(), sc.nextInt());
		}

		int connected = 0;
		for (int i = 1; i <= vertex; i++) {
			if (!visited[i]) {
				dfs(i);
				connected++;
			}
		}

		System.out.println(connected);
	}

	private static void addEdge(int x, int y) {
		graph[x][y] = 1;
		graph[y][x] = 1;
	}

	private static void dfs(int i) {
		visited[i] = true;

		for (int j = 1; j <= vertex; j++) {
			if (graph[i][j] == 1 && !visited[j]) {
				dfs(j);
			}
		}
	}
}