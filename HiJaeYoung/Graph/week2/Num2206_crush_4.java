package HiJaeYoung.Graph.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2206_crush_4 {
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
        Queue<int[]> que1 = new LinkedList<>();
        que1.add(new int[]{0, 0, 0});
        boolean[][][] vist = new boolean[maxH][maxW][2];
        int[][] cnt = new int[maxH][maxW];
        vist[0][0][0] = true;
        vist[0][0][1] = true;
        while (!que1.isEmpty()) {
            int [] arr = que1.poll();
            int nowH = arr[0];
            int nowW = arr[1];
            int isCrush = arr[2];

            for (int i = 0; i < 4; i++) {
                int nxtH = nowH + dx[i];
                int nxtW = nowW + dy[i];
                if (nxtW >= 0 && nxtW < maxW && nxtH < maxH && nxtH >= 0) {
                    // 1을 만나면 일단 부신 경우의 node를 que에 추가
                    if(map[nxtH][nxtW] == 1  && isCrush==0){
                        que1.add(new int[]{nxtH, nxtW,1});
                        cnt[nxtH][nxtW] = cnt[nowH][nowW]+1;
                    }
                    if (map[nxtH][nxtW] == 0 && !vist[nxtH][nxtW][isCrush]) {
                        vist[nowH][nowW][isCrush] = true;
                        que1.add(new int[]{nxtH, nxtW,isCrush});
                        cnt[nxtH][nxtW] = cnt[nowH][nowW]+1;
                    }
                    if (nxtH == maxH - 1 && nxtW == maxW - 1) {
                        return  cnt[nxtH][nxtW]+1;
                    }
                }
            }
        }
        return -1;
    }
}
