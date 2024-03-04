package HiJaeYoung.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Num15683_감시 {
    private static class CCTV{
        static int maxH;
        static int maxW;
        int h;
        int w;
        int type;
        int direction;
        public CCTV(int h, int w,int type,int direction){
            this.h =h;
            this.w=w;
            this.type =type;
            this.direction = direction;
        }
        public int calculate(int[][] map,boolean[][] vist){
            if(type==5){
                 return north(map,vist)+west(map,vist)+east(map,vist)+south(map,vist);
            }
            if(type==1){
                if(direction==1){
                    return north(map,vist);
                }
                if(direction==2){
                    return west(map,vist);
                }
                if(direction==3){
                    return east(map,vist);
                }
                if(direction==4){
                    return south(map,vist);
                }
            }
            if(type==2){
                if(direction==1){
                    return  north(map,vist)+south(map,vist);
                }
                if(direction==2){
                    return  west(map,vist)+east(map,vist);
                }
            }
            if(type==3){
                if(direction==1){
                    return north(map,vist)+east(map,vist);
                }
                if(direction==2){
                    return north(map,vist)+west(map,vist);
                }
                if(direction==3){
                    return south(map,vist)+east(map,vist);
                }
                if(direction==4){
                    return south(map,vist)+west(map,vist);
                }
            }
            if(type==4){
                if(direction==1){
                    return north(map,vist)+east(map,vist)+west(map,vist);
                }
                if(direction==2){
                    return north(map,vist)+west(map,vist)+south(map,vist);
                }
                if(direction==3){
                    return south(map,vist)+east(map,vist)+north(map,vist);
                }
                if(direction==4){
                    return south(map,vist)+west(map,vist)+east(map,vist);
                }
            }
            return 0;
        }
        private int north(int[][] map,boolean[][] vist){
            int count = 0;
            for(int i=this.h;i<maxH;i++){
                if(map[i][this.w] ==6){
                    break;
                }
                if(!vist[i][this.w]){
                    count++;
                    vist[i][this.w]=true;
                }

            }
            return count;
        }
        private int east(int[][] map,boolean[][] vist){
            int count = 0;
            for(int i=this.w;i<maxW;i++){
                if(map[this.h][i] ==6){
                    break;
                }
                if(!vist[this.h][i]){
                    count++;
                    vist[this.h][i]=true;
                }
            }
            return count;

        }
        private int west(int[][] map,boolean[][] vist){
            int count = 0;
            for(int i=this.w;i>=0;i--){
                if(map[this.h][i] ==6){
                    break;
                }
                if(!vist[this.h][i]){
                    count++;
                    vist[this.h][i]=true;
                }
            }
            return count;
        }
        private int south(int[][] map,boolean[][] vist){
            int count = 0;
            for(int i=this.h;i>=0;i--){
                if(map[i][this.w] ==6){
                    break;
                }
                if(!vist[i][this.w]){
                    count++;
                    vist[i][this.w]=true;
                }
            }
            return count;
        }

    }
    static int answer,space;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        CCTV.maxH = h;
        CCTV.maxW = w;
        List<List<CCTV>> cctvList = new ArrayList<>();
        space = 0;
        answer = Integer.MAX_VALUE;
        map = new int[h][w];
        for(int i=0;i<h;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<w;j++){
                int now = Integer.parseInt(st.nextToken());
                map[i][j] = now;
                if(now>=1 && now <=5){
                    cctvList.add(new ArrayList<>());
                    if(now==5){
                        cctvList.get(cctvList.size()-1).add(new CCTV(i,j,now,1));
                    }else if(now==2){
                        cctvList.get(cctvList.size()-1).add(new CCTV(i,j,now,1));
                        cctvList.get(cctvList.size()-1).add(new CCTV(i,j,now,2));
                    }else{
                        cctvList.get(cctvList.size()-1).add(new CCTV(i,j,now,1));
                        cctvList.get(cctvList.size()-1).add(new CCTV(i,j,now,2));
                        cctvList.get(cctvList.size()-1).add(new CCTV(i,j,now,3));
                        cctvList.get(cctvList.size()-1).add(new CCTV(i,j,now,4));
                    }
                    space++;
                }
                if(now == 0){
                    space++;
                }
            }
        }
        DFS(0,cctvList.size(),cctvList,new ArrayList<>());
        System.out.println(answer);
    }

    public static void DFS(int now , int maxDepth, List<List<CCTV>> cctvList,List<CCTV> tmp){
        if(now == maxDepth){
            answer = Math.min(calculate(tmp),answer);
            return;
        }
        for(CCTV cctv : cctvList.get(now)){
           tmp.add(cctv);
           DFS(now+1,maxDepth,cctvList,tmp);
           tmp.remove(tmp.size()-1);
        }
     }

    public static int calculate(List<CCTV> tmp){
        int totalspace = space;
        boolean[][] vist = new boolean[CCTV.maxH][CCTV.maxW];
        for(CCTV cctv:tmp){
            totalspace -= cctv.calculate(map,vist);
        }
        return totalspace;
    }
}
