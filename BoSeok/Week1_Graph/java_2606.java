package BoSeok.Week1_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class java_2606 {

    static int computer, lines;
    static int count = 0;

    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computer = Integer.parseInt(br.readLine());
        lines = Integer.parseInt(br.readLine());
        graph = new int[computer + 1][computer + 1];

        for (int i = 0; i <lines; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }


        // bfs 시작

        //1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
        LinkedList<Integer> Q = new LinkedList<Integer>();
        Q.add(1); // 1번 컴퓨터 추가
        visited = new boolean[computer+1];
        visited[1] = true; // 시작 컴퓨터 방문처리

        while(!Q.isEmpty()){
            int now = Q.poll();
            for (int next_node = 0; next_node <= computer; next_node++) {
                if(graph[now][next_node] == 1 && !visited[next_node] ){
                    Q.add(next_node);
                    visited[next_node] = true;
                    count ++;
                }
            }
        }
        System.out.println(count);
    }
}
