package HiJaeYoung.Graph.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 두개의 큐 사용하기
// 입출력값 좀 더 뺀시 하게 받는 법 찾아보기
// 시작하는 칸과 끝나는 칸도 cnt 증가 합니다
public class Num2206_crush {
    private static class Node{
        int h;
        int w;
        int cnt;
        Node(int h, int w,int cnt){
            this.h = h;
            this.w = w;
            this.cnt = cnt;
        }
    }
    static int[] dx={1,0,-1,0} , dy = {0,1,0,-1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int high = Integer.parseInt(st.nextToken());
        int wide = Integer.parseInt(st.nextToken());
        map = new int[high][wide];
        for(int i=0;i<high;i++){
            int index =0;
            for(char nowChar:bf.readLine().toCharArray()){
                map[i][index] = Character.getNumericValue(nowChar);
                index++;
            }
        }
        System.out.println(BFS(high,wide));
    }
    public static int BFS(int maxH, int maxW){
        Queue<Node> que1 = new LinkedList<>();
        Queue<Node> que2 = new LinkedList<>();
        que1.add(new Node(0,0,1));
        int answer = Integer.MAX_VALUE;
        boolean[][] vist = new boolean[maxH][maxW];
        while (!que1.isEmpty()){
            Node now = que1.poll();
            if(now.h==maxH-1 && now.w==maxW-1){
                answer =Math.min(answer, now.cnt);
            }
            vist[now.h][now.w] = true;
            for(int i=0;i<4;i++){
                int nxtH = now.h+dx[i];
                int nxtW = now.w+dy[i];
                // 시작점에서 부터 벽의 최소 거리가 갱신되어야 할 필요가 있을까 없을까 없..지
                if(nxtW>=0 && nxtW<maxW && nxtH<maxH && nxtH>=0&&!vist[nxtH][nxtW]){
                    if(map[nxtH][nxtW]==0){
                        vist[nxtH][nxtW] = true;
                        que1.add(new Node(nxtH,nxtW, now.cnt+1));
                    }else{
                        vist[nxtH][nxtW] = true; //여기서 해주는게 맞지
                        que2.add(new Node(nxtH,nxtW, now.cnt+1));
                    }
                }
            }
        }
        // 여기서 vist 값을 다시 설정 해야할 것 같구나
//        for(int i=0;i<maxH;i++){
//            Arrays.fill(vist[i],false);
//        }
//        벽에 시작 시 모든 각 탐색에 대해 vist를 초기화 해야함
        while (!que2.isEmpty()) {
            que1.add(que2.poll());
            for(int i=0;i<maxH;i++){
            Arrays.fill(vist[i],false);
            }
            while (!que1.isEmpty()){
                Node now = que1.poll();
                if(now.h==maxH-1 && now.w==maxW-1){
                    answer =Math.min(answer, now.cnt);
                }
                vist[now.h][now.w] = true;
                for(int i=0;i<4;i++){
                    int nxtH = now.h+dx[i];
                    int nxtW = now.w+dy[i];
                    if(nxtW>=0 && nxtW<maxW && nxtH<maxH && nxtH>=0&&!vist[nxtH][nxtW]){
                        if(map[nxtH][nxtW]==0){
                            vist[nxtH][nxtW] = true;
                            que1.add(new Node(nxtH,nxtW,now.cnt+1));
                        }
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
