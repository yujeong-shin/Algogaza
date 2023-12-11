package HiJaeYoung.Graph.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num2206_crush_2 {
    private static class Node{
        int h;
        int w;
        int cnt;
        boolean isCrush;

        Node(int h, int w, int cnt) {
            this.h = h;
            this.w = w;
            this.cnt = cnt;
            this.isCrush = false;
        }
        Node(int h, int w, int cnt,boolean isCrush) {
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
        PriorityQueue<Node> que1 = new PriorityQueue<>();
        que1.add(new Node(0, 0, 1));
        int answer = Integer.MAX_VALUE;
        int[][] vist = new int[maxH][maxW];
        for(int i=0;i<maxH;i++){
            Arrays.fill(vist[i],Integer.MAX_VALUE);
        }
        while (!que1.isEmpty()) {
            Node now = que1.poll();
            if (now.h == maxH - 1 && now.w == maxW - 1) {
                answer = Math.min(answer, now.cnt);
            }
            for (int i = 0; i < 4; i++) {
                int nxtH = now.h + dx[i];
                int nxtW = now.w + dy[i];
                if (nxtW >= 0 && nxtW < maxW && nxtH < maxH && nxtH >= 0) {
                    if (map[nxtH][nxtW] == 0 && now.cnt+1 <= vist[nxtH][nxtW]) {
                        vist[nxtH][nxtW] = now.cnt+1;
                        if(!now.isCrush){
                            que1.add(new Node(nxtH, nxtW, now.cnt + 1));
                        }else{
                            que1.add(new Node(nxtH, nxtW, now.cnt + 1,true));
                        }
                        // 1인 경우도 조건에 넣어줘야 함
                    } else if(map[nxtH][nxtW] == 1 &&!now.isCrush && now.cnt+1 <= vist[nxtH][nxtW]){
                        vist[nxtH][nxtW] = now.cnt+1;
                        que1.add(new Node(nxtH, nxtW, now.cnt + 1,true));
                    }
                }
            }
        }
        if(answer==Integer.MAX_VALUE){
            return -1;
        }
        return answer;
    }
}
