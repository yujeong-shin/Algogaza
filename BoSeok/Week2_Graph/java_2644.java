package BoSeok.Week2_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class java_2644 {
    static int n, x, y, m ;
    static boolean[] visited ;
    static int[] result;
/*
    graph = [[] for _ in range(N+1)]
            for i in range(m):
    a, b = map(int,sys.stdin.readline().split(" "))
    graph[a].append(b)
    graph[b].append(a)
    */
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); // 암기 필요
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        StringTokenizer stk = new StringTokenizer(bf.readLine());
        x = Integer.parseInt(stk.nextToken());
        y = Integer.parseInt(stk.nextToken());

        m = Integer.parseInt(bf.readLine());

        // 암기 필요
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[n+1];
        result = new int[n+1];

        dfs(x);
        System.out.println(result[y] != 0 ? result[y] : -1 );
    }
    private static void dfs(int x) {
        visited[x] = true; // 방문처리
        for (int i : graph.get(x)) { // 각 노드에서 뻗어나가는 노드 가져옴
            if (!visited[i]) { // 방문 안 했으면
                result[i] += result[x] + 1; // 1 촌 위에임
                dfs(i); // 다음 부모 찾으려 출격
            }
        }
    }
}
