package BoSeok.Week0521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class java_1717 {

    private static int N, M, find_x, find_y;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        int[] inputs = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        N = inputs[0];
        M = inputs[1];

//        부모 생성, 처음에 부모는 자기 자신이다.
//        부모란 연결이 되어있는 선중에 가장 작은 값이라고 이해 하면 좋을 것 같다.
        parents = IntStream.rangeClosed(0, N + 1).toArray();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int status = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

//            부모를 합침
            if (status == 0) {
                union(V, E);
            } else {
//                부모가 같은지 확인해봄
                if (find(V) == find(E)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static int find(int root) {
//        부모가 더 존재하면
        if (parents[root] != root) {
//            부모 찾으러 감
            parents[root] = find(parents[root]);
        }
//        없으면 내가 제일 부모임,
        return parents[root];
    }

    private static void union(int x, int y) {
//        제일 위에 부모를 찾아옴
        find_x = find(x);
        find_y = find(y);
//        작은 값으로 교체해줌
        if (find(find_x) > find_y) {
            parents[find_x] = find_y;
        }else {
            parents[find_y] = find_x;
        }
    }
}