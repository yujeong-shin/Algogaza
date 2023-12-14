package HiJaeYoung.Graph.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2206_crush_3 {
    private static class Node {
        int h;
        int w;
        int cnt;
        int isCrush;

        Node(int h, int w, int cnt) {
            this.h = h;
            this.w = w;
            this.cnt = cnt;
            this.isCrush = 0;
        }
        Node(int h, int w, int cnt,int isCrush) {
            this.h = h;
            this.w = w;
            this.cnt = cnt;
            this.isCrush = isCrush;
        }
    }

    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int high = Integer.parseInt(st.nextToken());
        int wide = Integer.parseInt(st.nextToken());
        map = new int[high][wide];
        for (int i = 0; i < high; i++) {
            int index = 0;
            for (char nowChar : bf.readLine().toCharArray()) {
                map[i][index] = Character.getNumericValue(nowChar);
                index++;
            }
        }
        System.out.println(BFS(high, wide));
    }

    public static int BFS(int maxH, int maxW) {
        Queue<Node> que1 = new LinkedList<>();
        que1.add(new Node(0, 0, 1));
        boolean[][][] vist = new boolean[maxH][maxW][2];
        vist[0][0][0] = true;
        vist[0][0][1] = true;
        while (!que1.isEmpty()) {
            Node now = que1.poll();
            // 1 1
            // 0
            // 인 경우에 1을 도출하기 위해 시작 시 검증한다
            if (now.h == maxH - 1 && now.w == maxW - 1) {
                return now.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int nxtH = now.h + dx[i];
                int nxtW = now.w + dy[i];
                if (nxtW >= 0 && nxtW < maxW && nxtH < maxH && nxtH >= 0) {
                    // 1을 만나면 일단 부신 경우의 node를 que에 추가하고 isCrush를 업뎃
                    if(map[nxtH][nxtW] == 1  && now.isCrush==0){
                        que1.add(new Node(nxtH, nxtW, now.cnt + 1,1));
                        vist[nxtH][nxtW][1] = true;
                    }
                    // vist을 체크할때 isCrush에 따른 값을 체킹!
                    if (map[nxtH][nxtW] == 0 && !vist[nxtH][nxtW][now.isCrush]) {
                        vist[nxtH][nxtW][now.isCrush] = true;
                        que1.add(new Node(nxtH, nxtW, now.cnt + 1, now.isCrush));
                    }

                }
            }
        }
        return -1;
    }
}
