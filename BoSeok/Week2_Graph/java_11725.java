package BoSeok.Week2_Graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class java_11725 {

    // 루트 없는 트리, 트리 루트는 1 각 노드의 부모를 구해라.
    // 이번엔 bfs !

    static int n, x, y, node;
    static int[]  visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); // 그래프 생성 빡세네
    static Queue<Integer> Q = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        // graph
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(stk.nextToken());
            y = Integer.parseInt(stk.nextToken());
            // 양방향
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        // visited start 0 >> n + 1
        visited = new int[n + 1];
        // bfs go
        Q.add(1); // 루트 노드 부터 탐색 레고
        while (!Q.isEmpty()) {
            node = Q.poll();
            // 노드랑 연결된 다음 노드들 다 가져옴
            for (int next_node : graph.get(node)) {
                // 방문 안했으면
                if (visited[next_node] == 0) {
                    // 다음노드(next_node)의 부모는 나(node)임
                    visited[next_node] = node;
                    Q.offer(next_node); // 다음 노드도 탐색하려 출발
                }
            }
        }
        IntStream.rangeClosed(2,n).forEach(x -> System.out.println(visited[x]));
    }
}
/*
    그래프 그리기 암기
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i <= n; i++) {
         graph.add(new ArrayList<>());
        }

    static Queue<Integer> Q = new LinkedList<>();
    */
