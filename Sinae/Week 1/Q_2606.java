import java.io.*;
import java.util.*;
import java.lang.*;

public class Q_2606 {
    public static int[][] matrix;
    public static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());

        matrix = new int[nodes + 1][nodes + 1];
        visited = new boolean[nodes + 1];

        for (int i = 0; i < edges; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }
        for (int i = 1; i < nodes + 1; i++) {
            if (!visited[i]) {
                dfs(1);
            }
        }
        System.out.print(count);

    }

    private static void dfs(int v) {
        visited[v] = true;
        for (int i = 0; i < matrix[v].length; i++) {
            if (!visited[i] && matrix[v][i] == 1) {
                System.out.println(i);
                dfs(i);
                count++;
            }
        }
    }
}
//7
//        6
//        1 2
//        2 3
//        1 5
//        5 2
//        5 6
//        4 7