//  나이트의 이동

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7562 {
	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[][] graph;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			graph = new int[n][n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			int result = bfs(n, startX, startY, endX, endY);
			list.add(result);
		}
		for (int a : list) {
			System.out.println(a);
		}
	}

	static int bfs(int l, int startX, int startY, int endX, int endY) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { startX, startY, 0 });
		graph[startX][startY] = 1;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			int x = current[0];
			int y = current[1];
			int moves = current[2];

			if (x == endX && y == endY) {
				return moves;
			}
			for (int i = 0; i < 8; i++) { // 이동 가능한 위치
				int newX = x + dx[i];
				int newY = y + dy[i];

				if (newX >= 0 && newX < l && newY >= 0 && newY < l && graph[newX][newY] == 0) {
					queue.add(new int[] { newX, newY, moves + 1 }); // 방문하지 않았으면 새 위치 추가
					graph[newX][newY] = 1;
				}
			}
		}

		return -1;
	}
}