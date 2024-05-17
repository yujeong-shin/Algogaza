package HiJaeYoung.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.StringTokenizer;

public class Num1520_내리막길 {
    static int H,W;
    static int[][] map;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        memo = new int[H][W];
        for(int i=0;i<H;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ;j<W;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(memo[i],-100);
        }
        DFS(H-1,W-1);
        memo[0][0] = 1;
//        for(int i=0;i<H;i++){
//            System.out.println(Arrays.toString(memo[i]));
//        }
        System.out.println(memo[H-1][W-1]);

    }
    public static int DFS(int h, int w){
        if(h==0 && w==0){
            return 1;
        }
        if(memo[h][w] != -100){
            return memo[h][w];
        }
        int nValue = 0;
        if(h-1>=0 && map[h-1][w]>map[h][w]){
            nValue = DFS(h-1,w);
        }
        int rValue = 0;
        if (w-1>=0 && map[h][w-1]>map[h][w]){
            rValue = DFS(h,w-1);
        }
        int dValue = 0;
        if (w+1<W && map[h][w+1]>map[h][w]){
            dValue = DFS(h,w+1);
        }
        int lValue = 0;
        if (h+1<H && map[h+1][w]>map[h][w]){
            lValue = DFS(h+1,w);
        }
        memo[h][w] = rValue+dValue+lValue+nValue;
        return memo[h][w];
    }
}
