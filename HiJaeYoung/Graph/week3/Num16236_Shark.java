package HiJaeYoung.Graph.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num16236_Shark {
    static int[][] map;
    static int[] dx ={0,0,1,-1}, dy={1,-1,0,0};
    static List<Node> nextFishes;
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
        public static Node moveMyshark(int h,int w,Node myShark){
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
            if(this.size==o.size){
                if(this.h==o.h){
                    return this.w - o.w;
                }
                return this.h - o.h;
            }
            return this.size - o.size;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Node> fishes = new PriorityQueue<>();
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
                    fishes.add(new Node(i,j,value));
                }
            }
        }
        int times = 0;
        nextFishes = new ArrayList<>();
        while (!fishes.isEmpty()){
            Node fish = fishes.poll();
            nextFishes.add(fish);
            //System.out.println(nextFishes.size());
            if(!fishes.isEmpty() && fishes.peek().size <babyShark.sharkSize){
                continue;
            }
            if(fish.size>= babyShark.sharkSize){
                break;
            }
            int time = Integer.MAX_VALUE;
            int index = 0, tmpH=Integer.MAX_VALUE,tmpW=Integer.MAX_VALUE;
            for(int i=0;i<nextFishes.size();i++){
                int nowTime = BFS(nextFishes.get(i),babyShark);
                if(nowTime==-1) {continue;}
                if(nowTime<time){
                    time = nowTime;
                    tmpH = nextFishes.get(i).h;
                    tmpW = nextFishes.get(i).w;
                    index = i;
                }else if (nowTime==time){
                    if(nextFishes.get(i).h<tmpH){
                        time = nowTime;
                        tmpH = nextFishes.get(i).h;
                        tmpW = nextFishes.get(i).w;
                        index = i;
                    }else if(nextFishes.get(i).h==tmpH){
                        if(nextFishes.get(i).w <tmpW){
                            time = nowTime;
                            tmpH = nextFishes.get(i).h;
                            tmpW = nextFishes.get(i).w;
                            index = i;
                        }
                    }
                }
            }
            //System.out.println("time "+time);
            babyShark = Node.moveMyshark(nextFishes.get(index).h,nextFishes.get(index).w,babyShark);
            babyShark.yumyum();
            //System.out.println("yum "+ nextFishes.get(index).h+" "+nextFishes.get(index).w+"shark size :"+babyShark.sharkSize);
            nextFishes.remove(index);
            for(Node nxtfish:nextFishes){
                fishes.add(nxtfish);
            }
            nextFishes.clear();
            if(time==Integer.MAX_VALUE){
                break;
            }else{
                times+=time;
            }
        }
        System.out.println(times);
    }
    public static int BFS(Node fish,Node shark){
        Queue<Node> que = new LinkedList<>();
        boolean[][] vist = new boolean[map.length][map.length];
        map[shark.h][shark.w] = 0;
        shark.resetMoveCount();
        que.add(shark);
        while(!que.isEmpty()){
            Node nowShark = que.poll();
            if(nowShark.h== fish.h && nowShark.w == fish.w){
                //System.out.println("eat fish "+fish.h+" "+fish.w);
                map[fish.h][fish.w] = 0;
                return nowShark.moveCount;
            }
            for(int i=0;i<4;i++){
                int nxtH = nowShark.h+dx[i];
                int nxtW = nowShark.w+dy[i];
                if(nxtH< map.length && nxtW< map.length&& nxtW>=0&&nxtH>=0 && !vist[nxtH][nxtW]){
                    if(map[nxtH][nxtW]<=nowShark.sharkSize){
                        vist[nxtH][nxtW] = true;
                        que.add(Node.moveMyshark(nxtH,nxtW,nowShark));
                    }
                }
            }
        }
        return -1;
    }
}
