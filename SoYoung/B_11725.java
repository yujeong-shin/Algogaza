// 트리의 부모 찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_11725 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 인접리스트
	static int vertex;
	static boolean[] visited;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		vertex = Integer.parseInt(br.readLine());

		for (int i = 0; i <= vertex; i++) { // 0 ~ 마지막 정점까지 빈 인접리스트 추가
			graph.add(new ArrayList<>()); 
		}

		for (int i = 0; i < vertex - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b); // 간선 연결
			graph.get(b).add(a);
		}

		visited = new boolean[vertex + 1];
		parent = new int[vertex + 1];

		dfs(1);

		for (int i = 2; i < parent.length; i++) { // 두번째 정점부터 부모출력
			System.out.println(parent[i]);
		}
	}

	static void dfs(int i) {
		visited[i] = true;

		for (int j : graph.get(i)) {
			if (!visited[j]) {
				dfs(j);
				parent[j] = i;
			}
		}
	}
}