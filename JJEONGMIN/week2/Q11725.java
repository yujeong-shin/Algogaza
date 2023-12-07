import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 기존에 해봤던 인접행렬 방식을 버리고 인접 리스트 형식을 함으로써 메모리 초과 이슈 해결 가능
public class Q11725 {
    static int N;
    static int[] result;
    static List<List<Integer>> treeArray;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        treeArray = new ArrayList<>(N+1);
        visited = new boolean[N + 1];
        result = new int[N+1];

        for (int i = 0; i <= N; i++) {
            treeArray.add(new ArrayList<>()); // 각 인덱스에 대한 내부 리스트 생성
        }
        for (int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 무방향 그래프이므로 양쪽으로 각각 추가
            // 한방향은 안돼? ㅇㅇ ㅇㅋ
            treeArray.get(a).add(b);
            treeArray.get(b).add(a);
        }

        dfs(1,1);

        for (int i =2; i < N + 1; i++) {
            System.out.println(result[i]);
        }
    }

    private static void dfs(int cur, int pre) {
        result[cur] = pre;
        visited[cur] = true;
        if(result.length == N) return;
        for(int next : treeArray.get(cur))
            if(!visited[next])
                dfs(next, cur);
    }
}
