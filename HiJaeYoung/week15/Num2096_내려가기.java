package HiJaeYoung.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num2096_내려가기 {
    static int [][] map;
    static int max, min,n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][3];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        int[][] maxValue  = new int[n][3];
        int[][] minValue = new int[n][3];
        for(int i=0;i<3;i++){
            maxValue[0][i] = map[0][i];
            minValue[0][i] = map[0][i];
        }
        DFS(1,maxValue,minValue);
        System.out.println(max+" "+min);
    }
    public static void DFS(int depth, int[][] maxValue,int [][] minValue){
        if(depth == n){
            max = Math.max(Math.max(maxValue[n-1][0],maxValue[n-1][1]),maxValue[n-1][2]);
            min = Math.min(Math.min(minValue[n-1][0],minValue[n-1][1]),minValue[n-1][2]);
            return;
        }
        maxValue[depth][0] = Math.max(maxValue[depth-1][0],maxValue[depth-1][1])+map[depth][0];
        maxValue[depth][1] = Math.max(Math.max(maxValue[depth-1][0],maxValue[depth-1][1]),maxValue[depth-1][2])+map[depth][1];
        maxValue[depth][2] = Math.max(maxValue[depth-1][1],maxValue[depth-1][2])+map[depth][2];

        minValue[depth][0] += Math.min(minValue[depth-1][0],minValue[depth-1][1])+map[depth][0];
        minValue[depth][1] += Math.min(Math.min(minValue[depth-1][0],minValue[depth-1][1]),minValue[depth-1][2])+map[depth][1];
        minValue[depth][2] += Math.min(minValue[depth-1][1],minValue[depth-1][2])+map[depth][2];

        DFS(depth+1,maxValue,minValue);
    }
}
