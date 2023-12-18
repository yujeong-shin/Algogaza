package HiJaeYoung.Graph.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2636Cheese {
    static int[][] map;
    static int[] dx={0,0,1,-1} , dy ={1,-1,0,0};
    private static class Node{
        int h;
        int w;
        Node(int h, int w){
            this.h = h;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w= Integer.parseInt(st.nextToken());
        map = new int[h][w];
        for(int i=0;i<h;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<w;j++){
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                // 치즈의 갯수가 필요한가..놉
            }
        }
        BFS(h, w);
    }
    public static void BFS(int h, int w){
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        boolean[][] vist = new boolean[h][w];
        q1.add(new Node(0,0));
        vist[0][0] = true;
        int count = 0;
        int time = 0;
        while(!q1.isEmpty() || !q2.isEmpty()){
            while(!q1.isEmpty()){
                Node now = q1.poll();
                //vist
                for(int i=0;i<4;i++){
                    int nxtH = now.h+dx[i];
                    int nxtW = now.w+dy[i];
                    if(nxtH<h && nxtH>=0 && nxtW<w && nxtW>=0){
                        if(!vist[nxtH][nxtW]){
                            if(map[nxtH][nxtW]==1){
                                count++;
                                vist[nxtH][nxtW] = true;
                                q2.add(new Node(nxtH,nxtW));
                            }else{
                                vist[nxtH][nxtW] = true;
                                q1.add(new Node(nxtH,nxtW));
                            }
                        }
                    }
                }
            }
            time++;
            if(q2.isEmpty()){
                break;
            }
            count=q2.size();
            while (!q2.isEmpty()){
                Node now = q2.poll();
                //vist
                for(int i=0;i<4;i++){
                    int nxtH = now.h+dx[i];
                    int nxtW = now.w+dy[i];
                    if(nxtH<h && nxtH>=0 && nxtW<w && nxtW>=0){
                        if(!vist[nxtH][nxtW]){
                            if(map[nxtH][nxtW]==1){
                                count++;
                                vist[nxtH][nxtW] = true;
                                q1.add(new Node(nxtH,nxtW));
                            }else{
                                vist[nxtH][nxtW] = true;
                                q2.add(new Node(nxtH,nxtW));
                            }
                        }
                    }
                }
            }
            time++;
            if(q1.isEmpty()){
                break;
            }
            count= q1.size();
        }
        System.out.println(time-1);
        System.out.println(count);
    }
}
