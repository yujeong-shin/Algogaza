package HiJaeYoung.Graph.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Num10026_RedGreen {
    static char[][] map;
    static boolean[][][] vist;
    static int[] dx={0,0,1,-1}, dy={1,-1,0,0};
    static class Node{
        int w,h;
        int colorBlindness;
        // 0 = allColor , 1 = colorBlindness
        Node(int h,int w, int colorBlindness){
            this.h = h;
            this.w = w;
            this.colorBlindness = colorBlindness;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        map = new char[n][n];
        vist = new boolean[n][n][2];
        int colorBlindness = 0, color = 0;
        for(int i=0;i<n;i++){
            map[i] = bf.readLine().toCharArray();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!vist[i][j][0]){
                    color++;
                    BFS(n,i,j,0);
                }
                if(!vist[i][j][1]){
                    colorBlindness++;
                    BFS(n,i,j,1);
                }
            }
            //System.out.println(Arrays.deepToString(vist));
        }
        System.out.println(color+" "+colorBlindness);
    }
    public static void BFS(int n,int h,int w, int colorBlindness){
        // 한번에 덱에 넣고 돌리고 싶은데..메모리 초과날까봐 걱정이요
        Deque<Node> dq = new LinkedList<>();
        vist[h][w][colorBlindness] = true;
        dq.addFirst(new Node(h,w,colorBlindness));
        while (!dq.isEmpty()){
            Node now = dq.pollLast();
            for(int i=0;i<4;i++){
                int nxtH = now.h+dx[i];
                int nxtW = now.w+dy[i];
                if(nxtW<n&&nxtW>=0&&nxtH<n&&nxtH>=0){
                    if(now.colorBlindness==0){
                        if(!vist[nxtH][nxtW][0] && map[now.h][now.w] == map[nxtH][nxtW]){
                            vist[nxtH][nxtW][now.colorBlindness] = true;
                            dq.addFirst(new Node(nxtH,nxtW,0));
                        }
                    }else if(now.colorBlindness==1){
                        if(!vist[nxtH][nxtW][1] && map[now.h][now.w] =='B'){
                            if(map[nxtH][nxtW]=='B'){
                                vist[nxtH][nxtW][now.colorBlindness] = true;
                                dq.addFirst(new Node(nxtH,nxtW,1));
                            }
                        }else if(!vist[nxtH][nxtW][1]){
                            if(map[nxtH][nxtW]=='R' || map[nxtH][nxtW]=='G'){
                                vist[nxtH][nxtW][now.colorBlindness] = true;
                                dq.addFirst(new Node(nxtH,nxtW,1));
                            }
                        }
                    }
                }
            }
        }
    }
}
