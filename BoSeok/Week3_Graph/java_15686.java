package BoSeok.Week3_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

// 치킨배달
// 조합필요
public class java_15686 {
    static int n, m;
    static int[][] graph;
    static int res = (int) 1e9;
    // 치킨 전체 담을 곳
    static ArrayList<Node> chicken = new ArrayList<>();
    // 집 담을 곳
    static ArrayList<Node> home = new ArrayList<>();

    // 치킨 일부만 담기
    static Stack<Object> BT = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    // 치킨집 담을 거
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

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(stk.nextToken());

                // 가정집 인 경우 home에 추가
                if (graph[i][j] == 1) {
                    home.add(new Node(i, j));
                }
                // 치킨집 인 경우 chicken 에 추가
                if (graph[i][j] == 2) {
                    // 치킨집 좌표 넣어줌
                    chicken.add(new Node(i, j));
                }
            }
        }
        // 시작값 0 부터, 갯수는 0개
        dfs(0, 0);
        System.out.println(res);
    }

    private static void dfs(int num, int count) {
        // m개의 치킨집을 찾았음 >> stk 에 담아있다
        // 치킨집을 m개 뽑고, 치킨집과 모든 집과의 거리를 담아서 최솟값을 갱신해야한다.


        // 치킨집을 m개 만큼 뽑았을때
        if (count == m) {
//             각 집 별로 치킨집과의 거리 담아놓을 곳
            int total = 0;
//             집 1개와 치킨집 여러개 비교
            for (int i = 0; i < home.size(); i++) {

//                 집 좌표들 가져온다.
                int a = home.get(i).x;
                int b = home.get(i).y;
//                 집 1개랑 m개의 치킨집 중 가장 가까운 곳을 저장하기 위한 변수

                int dist = (int) 1e9;
                for (int j = 0; j < BT.size(); j++) {
//
//                     각 치킨집 거리 가져온다.
                    Node chicken = (Node) BT.get(j);
                    int x = chicken.x;
                    int y = chicken.y;
//                    현재 집과 여러 치킨 집 중에 가장 짧은 값을 dist로 최신화.
                    dist = Math.min(dist, Math.abs(a - x) + Math.abs(b - y));
                }
//                각 집별 가장 짧은 치킨집의 거리를 total에 더한다.
                total += dist;
            }
//            지금 까지 구한 것과 최솟값으로 비교
            res = Math.min(total, res);
            return;
        }
        //2개 구하는 백트래킹 stack 사용
        for (int i = num; i < chicken.size(); i++) {
            BT.add(chicken.get(i));
            dfs(i + 1, count + 1);
            BT.pop();
        }
    }
}
