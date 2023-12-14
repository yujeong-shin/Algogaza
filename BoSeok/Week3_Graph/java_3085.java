package BoSeok.Week3_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class java_3085 {
    static int n, nx, ny, width, height;
    static int candy = (int) -1e9;
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static String[][] graph;
    static String temp;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken()); // n
        graph = new String[n][n];

        for (int x = 0; x < n; x++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine()); // 한 줄 읽기
            String row = stk.nextToken(); // ccp
            for (int y = 0; y < n; y++) {
                graph[x][y] = String.valueOf(row.charAt(y));
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int[] direction : move) {
                    nx = x + direction[0]; // x 좌표
                    ny = y + direction[1]; // y 좌표
                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
//                        1. 일단 옆이랑 사탕 비교해서 다르면 바꿔주고 아니면 그냥 진행
                        if (!graph[x][y].equals(graph[nx][ny])) { // 같지 않으면 사탕 바꿔줘야함
                            // 바꿔주기
                            temp = graph[x][y];
                            graph[x][y] = graph[nx][ny];
                            graph[nx][ny] = temp;
                        }
                        // 처음에 자기 자신 1개는 무조건 먹을 수 있음
                        width = 1; height = 1;
                        // 사탕 바꾸고 갯수 최댓값 레스고
                        for (int i = 0; i < n - 1; i++) {
                            // 가로로 같으면
                            if (graph[x][i].equals(graph[x][i + 1])) {
                                width ++;
                            }
                            // 다르면 다시 자기 기준으로 갯수를 세어야함
                            else width = 1;
                            // 세로
                            if (graph[i][y].equals(graph[i + 1][y])) {
                                height ++;
                            }
                            else height = 1;
//                            최댓값 매번 갱신화
                            candy = Math.max(Math.max(height,width),candy);
                        }
                        // 다시 바꿔줌
                        if (!graph[x][y].equals(graph[nx][ny])) {
                            // 다시 되돌려줌
                            graph[nx][ny] = graph[x][y];
                            graph[x][y] = temp;
                        }
                    }
                }
            }
        }
        System.out.println(candy);
    }
}
