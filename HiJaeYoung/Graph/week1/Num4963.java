package HiJaeYoung.Graph.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 입출력 받자마자 BFS 레츠고
// DFS로 할까..
// map은 static으로 전역변수
// map은 array로 레츠고

public class Num4963 {
    static int[] dx ={0,0,1,-1,1,1,-1,-1},dy ={1,-1,0,0,1,-1,1,-1};
    static int[][] map;
    static boolean[][] vist;
    static int w,h;
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int answer =0;
        while(true){
            answer =0;
            st = new StringTokenizer(bf.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h ==0){
                break;
            }
            map = new int[h][w];
            vist = new boolean[h][w];

            for(int i=0;i<h;i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0; j<w;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // w h가 max 50인데 구지 섬의 값을 저장해야하나
            // 안해!
            for(int i=0; i<h;i++){
                for(int j=0; j<w;j++){
                    if(!vist[i][j] && map[i][j]==1){
                        vist[i][j] = true;
                        answer++;
                        DFS(i,j);
                    }
                }
            }
            sb.append(answer+"\n");
        }
        System.out.println(sb);
    }
    public static void DFS(int nowH , int nowW){
        for(int i=0;i<8;i++){
            int nxtH = nowH+dx[i];
            int nxtW = nowW+dy[i];
            if(nxtW>=0&& nxtW<w && nxtH>=0 && nxtH<h && !vist[nxtH][nxtW]&& map[nxtH][nxtW]==1){
                vist[nxtH][nxtW] = true;
                DFS(nxtH,nxtW);
            }
        }
    }

}
