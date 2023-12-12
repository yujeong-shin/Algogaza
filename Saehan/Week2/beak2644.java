import java.io.*;
import java.util.*;

public class beak2644 {
    static int n, a, b, m;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        System.out.println(bfs(a, b));
    }

    static int bfs(int start, int target) {
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            if (currentNode == target)
                return currentDist;

            if (!visited[currentNode]) {
                visited[currentNode] = true;

                for (int n_Node : graph.get(currentNode)) {
                    if (!visited[n_Node]) {
                        queue.add(new int[]{n_Node, currentDist + 1});
                    }
                }
            }
        }
        return -1;
    }
}