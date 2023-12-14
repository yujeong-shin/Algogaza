package BoSeok.Week2_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class java_7562 {
    static int[][] graph;
    static int t, l, target_x, target_y, start_x, start_y;
    static int[][] move = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    static int nx, ny;
    static Queue<Node> Q = new LinkedList<Node>();

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine()); // t
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(bf.readLine());

            StringTokenizer stk = new StringTokenizer(bf.readLine());

            // 시작 지점
            start_x = Integer.parseInt(stk.nextToken());
            start_y = Integer.parseInt(stk.nextToken());

            // 타겟지점
            stk = new StringTokenizer(bf.readLine());
            target_x = Integer.parseInt(stk.nextToken());
            target_y = Integer.parseInt(stk.nextToken());

            // 그래프 생성및 시작지점 초기화
            graph = new int[l][l];
            graph[start_x][start_y] = 1;
            Q = new LinkedList<Node>();

            sb.append(bfs(start_x, start_y)).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int x, int y) {
        Q.offer(new Node(x, y));

        while (!Q.isEmpty()) {
            Node node = Q.poll();
//            target 맞추면 끝냄
            if (node.x == target_x && node.y == target_y) {
                return graph[node.x][node.y] - 1;
            }

            for (int[] next_node : move) {
                int dx = next_node[0];
                int dy = next_node[1];
//                다음 노드
                nx = node.x + dx;
                ny = node.y + dy;
                if (0 <= nx && nx < l && 0 <= ny && ny < l && graph[nx][ny] == 0) {
                    graph[nx][ny] = graph[node.x][node.y] + 1;
                    Q.offer(new Node(nx, ny));
                }
            }
        }
        return 0;
    }
}

// visited 필요 없음, graph 가 0 으로 초기화 되면서 각 좌표마다 최단거리를
// 최신화 시켜주므로 0 이 아니면 방문 한거임


