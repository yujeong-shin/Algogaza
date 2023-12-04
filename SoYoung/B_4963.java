// 섬의 개수

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int[][] graph;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int w = sc.nextInt();
			int h = sc.nextInt();

			if (w == 0 && h == 0) {
				break;
			}

			graph = new int[h][w];

			int count = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					graph[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (graph[i][j] == 1) {
						count += 1;
						dfs(i, j, h, w);
					}
				}
			}
			list.add(count);
			count = 0;
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static void dfs(int x, int y, int h, int w) {
		if (x < 0 || x >= h || y < 0 || y >= w || graph[x][y] == 0) {
			return;
		}

		graph[x][y] = 0;

		dfs(x - 1, y, h, w);
		dfs(x + 1, y, h, w);
		dfs(x, y - 1, h, w);
		dfs(x, y + 1, h, w);
		dfs(x - 1, y - 1, h, w);
		dfs(x - 1, y + 1, h, w);
		dfs(x + 1, y - 1, h, w);
		dfs(x + 1, y + 1, h, w);
	}
}