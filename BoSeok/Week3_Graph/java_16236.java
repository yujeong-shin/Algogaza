package BoSeok.Week3_Graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class java_16236 {
    static int n;
    static int res, eat_size, size = 2;
    //    다음 x, y노드, 지금 x,y 노드
    static int nx, ny, now_x, now_y;

    static int next_x, next_y, distance;

//    그래프, 방문기록, 거리기록
    static int[][] graph, visited, dis;
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static LinkedList<next_node> next_eat = new LinkedList<>();


    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class next_node {
        int nx;
        int ny;
        int distance;

        public next_node(int nx, int ny, int distance) {
            this.nx = nx;
            this.ny = ny;
            this.distance = distance;
        }

        public int getNx() {
            return nx;
        }

        public int getNy() {
            return ny;
        }

        public int getDistance() {
            return distance;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(stk.nextToken());
//                초기 값 세팅
                if (graph[i][j] == 9) {
                    now_x = i;
                    now_y = j;
                }
            }
        }
        while (true) {
            next_eat = bfs(now_x, now_y, size);
//            먹을게 없으면 종료
            if (next_eat.size() == 0) {
                break;
            }
//            크기순, 맨위, 맨왼쪾 기준 오름차순 > 맨 왼쪽꺼 poll
            next_eat.sort(Comparator.comparing(next_node::getDistance)
                    .thenComparing(next_node::getNx)
                    .thenComparing(next_node::getNy));
            next_node n_node = next_eat.poll();

            res += n_node.distance;

//            원래자리 0 으로
            graph[now_x][now_y] = 0;
//            도착한자리 0 으로
            graph[n_node.nx][n_node.ny] = 0;

//            위치 바꿔줌
            now_x = n_node.nx;
            now_y = n_node.ny;

//            한마리 먹고
            eat_size += 1;

//            마리수만큼 먹었으면
            if (eat_size == size) {
                //진화
                size += 1;
                // 초기화
                eat_size = 0;
            }
        }
        System.out.println(res);
    }

    private static LinkedList<next_node> bfs(int nowX, int nowY, int size) {
//        방문리스트
        visited = new int[n][n];

//        거리 담기
        dis = new int[n][n];

//        방문처리
        visited[nowX][nowY] = 1;
//        Q, 다음 시작위치 라인업 넣을 next_Q
        LinkedList<Node> Q = new LinkedList<>();
        LinkedList<next_node> next_Q = new LinkedList<>();
        Q.add(new Node(nowX, nowY));
        while (!Q.isEmpty()) {
            Node node = Q.poll();
            for (int[] direction : move) {
                nx = node.x + direction[0];
                ny = node.y + direction[1];

//            범위 안에 들어왔고, 아직 방문 하지 않았으면
                if (0 <= nx && nx < n && 0 <= ny && ny < n && visited[nx][ny] == 0) {
//                나보다 작으면 먹고, 같으면 지나가기만 가능함.
//                지나가기 + 먹기
                    if (graph[nx][ny] <= size) {
//                다음 노드 추가해주고
                        Q.add(new Node(nx, ny));
//                거리 1 더해주고
                        dis[nx][ny] = dis[node.x][node.y] + 1;
//                방문 처리까지 해준다.
                        visited[nx][ny] = 1;
//                    잡아먹기 리스트에 추가
                        if (graph[nx][ny] < size && graph[nx][ny] != 0) {
                            next_Q.add(new next_node(nx, ny, dis[nx][ny]));
                        }
                    }
                }
            }
        }
//        잡아먹을 리스트 담은 Q 리턴
        return next_Q;
//        파이썬 거리, x좌표, y좌표 정렬
//        sorted(next_Q, key = lambda x : (-x[2],-x[0],-x[1]))
    }
}
