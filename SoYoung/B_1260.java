// DFS와 BFS

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_1260 {
	static int vertex;
	static int edge;
	static int start;
	static LinkedList<Integer> adj_list[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		vertex = sc.nextInt();
		edge = sc.nextInt();
		start = sc.nextInt();

		Graph g = new Graph(vertex);

		for (int i = 0; i < edge; i++) {
			g.addEdge(sc.nextInt() - 1, sc.nextInt() - 1);
		}

		g.dfs(start - 1); 
		System.out.println();
		g.bfs(start - 1);
	}

	private static class Graph {
		LinkedList<Integer> adj_list[];

		public Graph(int v) {
			adj_list = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				adj_list[i] = new LinkedList<>();
			}
		}

		public void addEdge(int i1, int i2) {
			adj_list[i1].add(i2);
			adj_list[i2].add(i1); 
		}

		private void DFS_helper(int v, boolean visited[]) {
			visited[v] = true;
			System.out.print((v + 1) + " "); 

			LinkedList<Integer> sortedAdjList = new LinkedList<>(adj_list[v]);
			Collections.sort(sortedAdjList);
			Iterator<Integer> i = sortedAdjList.listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n])
					DFS_helper(n, visited);
			}
		}

		public void dfs(int i) {
			boolean visited[] = new boolean[adj_list.length];
			DFS_helper(i, visited);
		}

		public void bfs(int root_node) {
			boolean visited[] = new boolean[vertex];
			Queue<Integer> queue = new LinkedList<Integer>();

			visited[root_node] = true;
			queue.add(root_node);

			while (!queue.isEmpty()) {
				int current_node = queue.poll();
				System.out.print((current_node + 1) + " ");

				LinkedList<Integer> sortedAdjList = new LinkedList<>(adj_list[current_node]);
				Collections.sort(sortedAdjList);
				Iterator<Integer> i = sortedAdjList.listIterator();
				while (i.hasNext()) {
					int neighbor = i.next();
					if (!visited[neighbor]) {
						visited[neighbor] = true;
						queue.add(neighbor);
					}
				}
			}
		}
	}
}