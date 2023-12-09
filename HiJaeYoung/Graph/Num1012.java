package HiJaeYoung.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.List;

// 다중 테스트. (m*n*nlon)*T
// 메서드 잘 나눠라 ~
// 상하좌우 탐색이 필요. 이중배열
// nm 구분잘하기.^^
// 인접리스트와 인접행렬의 차이
public class Num1012 {
    static int[] dx ={1,0,-1,0}, dy ={0,1,0,-1};
    static class node{
        int x;
        int y;
        public node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<testcase;i++){
            StringTokenizer st;
            st = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean[][] vist = new boolean[n+1][m+1];
            int[][] map = new int[n+1][m+1];
            List<node> veg = new LinkedList<>();
            for(int j=0;j<k;j++){
                st = new StringTokenizer(bf.readLine());
                int nowm = Integer.parseInt(st.nextToken());
                int nown = Integer.parseInt(st.nextToken());
                map[nown][nowm] = 1;
                veg.add(new node(nowm,nown));
            }
            sb.append(BFS(map,m,n,veg,vist)+"\n");
        }
        System.out.print(sb);
    }

    public static int BFS(int[][] map, int max_m,int max_n,List<node> vegs,boolean[][] vist){
        Queue<node> que = new LinkedList<>();
        int answer =0;
        for(node nowveg : vegs){
            if(map[nowveg.y][nowveg.x]==1){
                answer++;
                que.add(nowveg);
                //System.out.println("y : " +nowveg.y +"x : "+nowveg.x);
                while (!que.isEmpty()){
                    node nowNode = que.poll();
                    map[nowNode.y][nowNode.x] =0;
                    for(int i=0;i<4;i++){
                        int nxtx = nowNode.x+dx[i];
                        int nxty = nowNode.y+dy[i];
                        //0도 통과해야겠지?
                        if(nxty>=0 && nxtx<max_m && nxtx>=0 && nxty<max_n){
                            if(map[nxty][nxtx]==1 && !vist[nxty][nxtx]){
                                vist[nxty][nxtx] = true;
                                que.add(new node(nxtx,nxty));
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}