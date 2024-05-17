package HiJaeYoung.Graph.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num16236_Shark2 {
    static int[][] map;
    private static class Node implements Comparable<Node>{
        int h;
        int w;
        int size;
        int sharkSize;
        int eatenFish;
        int moveCount;
        Node(int h,int w,int size){
            this.h= h;
            this.w= w;
            this.size = size;
        }
        //shark Constructor
        Node(int h,int w){
            this.h= h;
            this.w= w;
            this.sharkSize =2;
            this.eatenFish =0;
            this.moveCount = 0;
        }
        public static Node moveMyshark(int h, int w, Node myShark){
            Node movedShark = new Node(h,w);
            movedShark.sharkSize = myShark.sharkSize;
            movedShark.moveCount = myShark.moveCount+1;
            movedShark.eatenFish = myShark.eatenFish;
            return movedShark;
        }
        public void resetMoveCount(){
            this.moveCount = 0;
        }
        public void yumyum(){
            this.eatenFish += 1;
            if(eatenFish==sharkSize){
                this.eatenFish=0;
                sharkSize++;
            }
        }
        @Override
        public int compareTo(Node o){
            if(this.moveCount==o.moveCount){
                if(this.h==o.h){
                    return this.w - o.w;
                }
                return this.h - o.h;
            }
            return this.size - o.size;
        }
    }
    static int[] dx ={0,0,1,-1}, dy={1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int numberOfFish =0;
        map = new int[n][n];
        Node babyShark = null;
        // input
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                int value=Integer.parseInt(st.nextToken());
                map[i][j]=value;
                if(value==9){
                    babyShark = new Node(i,j);
                }else if(value!=0){
                    numberOfFish++;
                }
            }
        }
        if (numberOfFish==0){
            System.out.println(0);
        }else{
            System.out.println(BFS(babyShark));
        }
    }
    public static int BFS(Node shark){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] vist = new boolean[map.length][map.length];
        map[shark.h][shark.w] =0;
        pq.add(shark);
        int times=0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(map[now.h][now.w] <now.sharkSize){
                map[now.h][now.w] = 0;
                vist = new boolean[map.length][map.length];
                times+=now.moveCount;
                now.moveCount=0;
                now.eatenFish++;
                if(now.eatenFish==now.sharkSize){
                    now.eatenFish=0;
                    now.sharkSize++;
                }
                pq.clear();
                pq.add(now);
            }
            for(int i=0;i<4;i++){
                int nxtH = now.h+dx[i];
                int nxtW = now.w+dy[i];
                if(nxtH< map.length && nxtW< map.length&& nxtW>=0&&nxtH>=0 && !vist[nxtH][nxtW]){
                    if(map[nxtH][nxtW]<=now.sharkSize){
                        vist[nxtH][nxtW] = true;
                        pq.add(Node.moveMyshark(nxtH,nxtW,now));
                    }
                }

            }
        }
        return times;
    }
}
