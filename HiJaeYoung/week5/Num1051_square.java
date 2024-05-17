package HiJaeYoung.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num1051_square {
    static char[][] map;
    static int h, w,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(bf.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        for(int i=0;i<h;i++){
            map[i] = bf.readLine().toCharArray();
        }
        //System.out.println(Arrays.deepToString(map));
        answer = 1;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                search(i,j);
            }
        }
        System.out.println(answer);
    }
    public static  void search(int nowH, int nowW){
        int length = 1;
        while (true){
            if(nowH+length<h && nowW+length<w){
                if(map[nowH][nowW] == map[nowH+length][nowW]
                        && map[nowH][nowW] ==map[nowH][nowW+length]
                        && map[nowH][nowW] ==map[nowH+length][nowW+length]){
                    answer = Math.max(answer,(length+1)*(length+1));
                }
            }else{
                break;
            }
            length++;
        }
    }
}
