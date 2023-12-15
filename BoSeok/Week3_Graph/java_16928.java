package BoSeok.Week3_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class java_16928 {
    static int n, m, next_node;
    static int[] dp = new int[101];
    static boolean[] visited;
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
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        visited = new boolean[101];

        for (int i = 0; i < n + m; i++) {
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            dp[a] = b; // a를 밟으면 b로 이동함.
        }

        Q.add(new Node(1, 0)); // 시작지점, 이동횟수
        while (!Q.isEmpty()) {
            Node node = Q.poll();
            System.out.println("s");
            if (node.x == 100) {
                System.out.println(node.y);
                break;
            }
            for (int add = 1; add < 7; add++) { // 주사위 굴려서 1~6 까지 가능
                next_node = node.x + add;
                if (next_node <= 100 && visited[next_node] == false) { // 방문 안 했을 경우
                    visited[next_node] = true; // 방문 해주고
                    if (dp[next_node] != 0) { // 선이 연결되어 있으면
                        next_node = dp[next_node]; // 다음 선을 그걸로 바꿔줌
                    }
                    Q.add(new Node(next_node, node.y + 1));
                }
            }
        }
    }
}
