import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16928 {
    static int[][] treeArray;
    static boolean[][] bridge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        treeArray = new int[101][101];
        bridge = new boolean[101][101];

        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bridge[A][B] = false;
        }

        bfs();

    }
    private static void bfs() {
        int current_num = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(current_num);
    }
}
