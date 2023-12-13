package HiJaeYoung.Graph.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Num3085_candy {
    static char[][] map;
    static int n;
    static int[] dx ={0,0,-1,1} , dy={1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new char[n][n];
        int answer =0;
        for(int i=0;i<n;i++){
            String input = bf.readLine();
            for(int j=0;j<n;j++){
                map[i][j] = input.charAt(j);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                answer = Math.max(answer,change(i,j));
            }
        }
        System.out.println(answer);
    }
    public static int change(int h,int w){
        int answer =0;
        for(int i=0;i<4;i++){
            if(h+dx[i]<n && h+dx[i]>=0 &&w+dy[i]<n &&w+dy[i]>=0){
                if(map[h][w] != map[h+dx[i]][w+dy[i]]){
                    char tmp = map[h][w];
                    map[h][w] = map[h+dx[i]][w+dy[i]];
                    map[h+dx[i]][w+dy[i]] = tmp;
                    answer = Math.max(find(),answer);
                    map[h+dx[i]][w+dy[i]] = map[h][w];
                    map[h][w] =tmp;
                }
            }
        }
        return answer;
    }
    public static int find(){
        int answer = -1;
        for(int i=0;i<n;i++){
            int cnt_w = 1;
            int cnt_h = 1;
            for(int j=0;j<n-1;j++){
                if(map[i][j]==map[i][j+1]){
                    cnt_w++;
                    answer =Math.max(answer,cnt_w);
                }else{
                    cnt_w = 1;
                }
                if(map[j][i] == map[j+1][i]){
                    cnt_h++;
                    answer = Math.max(answer,cnt_h);
                }else{
                    cnt_h=1;
                }
            }
        }
        return answer;
    }
}
