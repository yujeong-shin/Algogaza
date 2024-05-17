package HiJaeYoung.Graph.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num16236_Shark3 {
    static int[][] map;
    static int[] dx ={0,0,1,-1}, dy={1,-1,0,0};
    static List<Fish> nextFishes;

    private static class Fish implements Comparable<Fish>{
        int h;
        int w;
        int size;
        Fish(int h,int w,int size){
            this.h= h;
            this.w= w;
            this.size = size;
        }

        @Override
        public int compareTo(Fish o){
            if(this.size==o.size){
                if(this.h==o.h){
                    return this.w - o.w;
                }
                return this.h - o.h;
            }
            return this.size - o.size;
        }
    }
    // Fish를 상속 받는 Shark Class
    private static class Shark extends Fish{
        int eatenFish;
        int moveCount;
        Shark(int h,int w){
            super(h,w,2);
            this.eatenFish = 0;
            this.moveCount = 0;
        }
        // moveMYShark method를 구지 클래스 메서드로 만들 이유가 있을까
//        public static void moveMyshark(int h, int w, Shark nowShark){
//            nowShark.move(h,w);
//        }
        public Shark moveShark(int h,int w){
            Shark nextShark = new Shark(h,w);
            nextShark.moveCount = this.moveCount+1;
            nextShark.size = this.size;
            return nextShark;
        }
        public void resetMoveCount(){
            this.moveCount = 0;
        }
        public void yumyum(){
            this.eatenFish += 1;
            if(eatenFish==this.size){
                this.eatenFish=0;
                this.size++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        Shark babyShark = null;

        // input
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                int value=Integer.parseInt(st.nextToken());
                map[i][j]=value;
                if(value==9){
                    babyShark = new Shark(i,j);
                }
            }
        }
        int times = 0;
        nextFishes = new ArrayList<>();
        while (true){
            Fish nextFish = findNextFish(babyShark);
            if(nextFish==null){
                break;
            }
            //System.out.println("time "+time);
            //babyShark.move(nextFish.h,nextFish.w);
            babyShark.yumyum();
            //System.out.println("yum "+ nextFishes.get(index).h+" "+nextFishes.get(index).w+"shark size :"+babyShark.sharkSize);
        }
        System.out.println(times);
    }
    public static Fish findNextFish(Shark babyShark){
        Fish fish = null;
        List<Fish> fishList = BFS(babyShark);
        if(fishList.isEmpty()){
            return fish;
        }
        int index = 0, tmpH=Integer.MAX_VALUE,tmpW=Integer.MAX_VALUE;
        for(int i=0;i<fishList.size();i++){
                tmpH = fishList.get(i).h;
                tmpW = fishList.get(i).w;
                index = i;
                if(nextFishes.get(i).h<tmpH){
                    tmpH = nextFishes.get(i).h;
                    tmpW = nextFishes.get(i).w;
                    index = i;
                }else if(nextFishes.get(i).h==tmpH){
                    if(nextFishes.get(i).w <tmpW){
                        tmpH = nextFishes.get(i).h;
                        tmpW = nextFishes.get(i).w;
                        index = i;
                    }
                }
            }
        return fishList.get(index);
    }
    public static List<Fish> BFS(Shark shark){
        Queue<Shark> que = new LinkedList<>();
        boolean[][] vist = new boolean[map.length][map.length];
        List<Fish> fishList = new ArrayList<>();
        map[shark.h][shark.w] = 0;
        shark.resetMoveCount();
        int count = Integer.MAX_VALUE;
        que.add(shark);
        while(!que.isEmpty()){
            Shark nowShark = que.poll();
            if(nowShark.moveCount>=count){
                continue;
            }
            for(int i=0;i<4;i++){
                int nxtH = nowShark.h+dx[i];
                int nxtW = nowShark.w+dy[i];
                if(nxtH< map.length && nxtW< map.length&& nxtW>=0&&nxtH>=0 && !vist[nxtH][nxtW]){
                    if(map[nxtH][nxtW]<=nowShark.size){
                        vist[nxtH][nxtW] = true;
                        if(map[nxtH][nxtW]<nowShark.size){
                            fishList.add(new Fish(nxtH,nxtW,map[nxtH][nxtW]));
                            count = Math.min(count,nowShark.moveCount+1);
                        }
                        que.add(nowShark.moveShark(nxtH,nxtW));
                    }
                }
            }
        }
        return fishList;
    }
}
