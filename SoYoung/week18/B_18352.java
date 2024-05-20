package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_18352 {
    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>()); // 내부 리스트 초기화 -> 연결된 노드
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            addEdge(st.nextToken(), st.nextToken());
        }

        visited = new boolean[n+1];
        distance = new int[n+1];
        bfs(x, k);

        if(result.isEmpty()) System.out.println(-1);
        else {
            Collections.sort(result);
            for(Integer a : result) {
                System.out.println(a);
            }
        }
    }

    static void addEdge(String a, String b) {
        list.get(Integer.parseInt(a)).add(Integer.parseInt(b));
    }

    static void bfs(int start, int dist) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll(); // 현재 위치를 꺼내면서(방문)
            for (int next : list.get(now)) {
                if (visited[next] != true) {
                    queue.add(next); // 이어진 노드(방문예정)를 큐에 삽입
                    visited[next] = true;
                    distance[next] = distance[now] + 1; // 직전 노드의 거리 + 1
                    if (distance[next] == dist) {
                        result.add(next);
                    }
                }
            }
        }
    }
}
