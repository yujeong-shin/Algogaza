//  미로 탐색

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2178 {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] graph;
	static int num = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] x = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(x[j]);
			}
		}

		int result = bfs(n, m, graph);

		System.out.println(result);

	}

	private static int bfs(int n, int m, int[][] graph) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { 0, 0, 1 });
		graph[0][0] = 0;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			int x = current[0];
			int y = current[1];
			int moves = current[2];

			if (x == n - 1 && y == m - 1) {
				return moves;
			}
			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];

				if (newX >= 0 && newX < n && newY >= 0 && newY < m && graph[newX][newY] == 1) {
					queue.add(new int[] { newX, newY, moves + 1 }); // 방문하지 않은 위치면 추가
					graph[newX][newY] = 0;
				}
			}
		}
		return -1;
	}
}