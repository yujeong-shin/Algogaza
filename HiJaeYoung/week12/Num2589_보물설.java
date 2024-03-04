package HiJaeYoung.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2589_보물설 {
    static char[][] map;
    static int[][] dist;
    static boolean[][] vist;
    static int h ,w,answer;
    static int[] dx = {1,-1,0,0} , dy ={0,0,1,-1};
    private static class Node{
        int h;
        int w;
        int value;
        public Node(int h, int w, int value){
            this.value =value;
            this.h = h;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        dist = new int[h][w];
        answer = 0;
        for(int i=0;i<h;i++){
            map[i] = br.readLine().toCharArray();
        }
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(map[i][j] =='L'){
                    BFS(i,j);
                }
            }
        }
        System.out.println(answer);
    }
    public static void BFS(int nowH, int nowW){
        vist = new boolean[h][w];
        vist[nowH][nowW] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(nowH,nowW,0));
        while(!queue.isEmpty()){
            Node now = queue.poll();
            dist[now.h][now.w]  = now.value;
            for(int i=0;i<4;i++){
                int nextW = now.w+dx[i];
                int nextH = now.h+dy[i];
                if(nextW >=0 && nextW<w && nextH>=0 && nextH<h ){
                    if(map[nextH][nextW] == 'L' && !vist[nextH][nextW]){
                        vist[nextH][nextW] = true;
                        answer = Math.max(answer,now.value+1);
                        queue.add(new Node(nextH,nextW,now.value+1));
                    }
                }
            }
        }
    }

}
