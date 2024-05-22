package BoSeok.Week0521;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class java_1753 {
    static class Edge implements Comparable<Edge> {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("/Users/song/Desktop/Python/Python/h.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine().trim());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
        }

        dist[k] = 0;

        PriorityQueue<Edge> heap = new PriorityQueue<>();
        heap.add(new Edge(k, 0));
        while (!heap.isEmpty()) {
            Edge curr = heap.poll();
            int cur_w = curr.weight;
            int cur_node = curr.to;
            if (cur_w > dist[cur_node]) {
                continue;
            }
            for (Edge edge : graph.get(cur_node)) {
                int newDist = cur_w + edge.weight;
                if (newDist < dist[edge.to]) {
                    dist[edge.to] = newDist;
                    heap.offer(new Edge(edge.to, newDist));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF").append('\n');
            else sb.append(dist[i]).append('\n');
        }
        System.out.print(sb);
    }
}