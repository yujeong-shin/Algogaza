package HiJaeYoung.Graph.week2;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Num2206_refer {
    static int[][] graph;
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int N, M;
    static int[][] count;

    static int[] da = { 1, -1, 0, 0 };
    static int[] db = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로의 수
        M = Integer.parseInt(st.nextToken()); // 가로의 수

        visited = new boolean[N + 1][M + 1][2];
        graph = new int[N + 1][M + 1];
        count = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                char ch = str.charAt(j - 1);
                graph[i][j] = Character.getNumericValue(ch);
            }
        }
        bfs();

//        for (int i = 1; i <= N; i++) {
//            System.out.println("");
//            for (int j = 1; j <= M; j++) {
//                System.out.print(count[i][j]);
//            }
//        }

        if (count[N][M] != 0) {
            System.out.print(count[N][M] + 1);
        } else {
            System.out.print(-1);
        }
    }

    static void bfs() {
        queue.add(new int[] { 1, 1, 0 });
        visited[1][1][0] = true;
        visited[1][1][1] = true;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];

            for (int i = 0; i < 4; i++) {
                int ad = a + da[i];
                int bd = b + db[i];

                if (ad >= 1 && ad <= N && bd >= 1 && bd <= M) {
                    if (graph[ad][bd] == 1 && c == 0) {
                        //부셔야하는 경우인데 하나도 안부셔서 부실수있는경우
                        queue.add(new int[] { ad, bd, 1 });
                        count[ad][bd] = count[a][b] + 1;
                    }

                    if (graph[ad][bd] == 0) {
                        if (visited[ad][bd][c] == false) {
                            queue.add(new int[] { ad, bd, c });
                            visited[ad][bd][c] = true;
                            count[ad][bd] = count[a][b] + 1;
                        }
                    }

                }
                if (count[N][M] != 0) {
                    break;
                }

            }

        }
    }
}