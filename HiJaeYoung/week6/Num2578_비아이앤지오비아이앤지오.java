package HiJaeYoung.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num2578_비아이앤지오비아이앤지오 {
    private static class Node{
        int h;
        int w;
        Node(int h, int w){
            this.h = h;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Node[] location = new Node[26];
        int[][] map = new int[26][26];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st;
        for(int i=1;i<6;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<6;j++){
                location[Integer.parseInt(st.nextToken())] = new Node(i,j);
            }
        }
        for(int i=0;i<5;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<6;j++){
                int tmp = Integer.parseInt(st.nextToken());
                map[location[tmp].h][location[tmp].w] = (i*5)+j;
            }
        }
        // 가로 새로 빙고 가능 카운트 추가
        for(int i=1;i<6;i++){
            int wideMax = 0;
            int highMax = 0;
            for(int j=1;j<6;j++){
                wideMax = Math.max(wideMax,map[i][j]);
                highMax = Math.max(highMax,map[j][i]);
            }
            pq.add(wideMax);
            pq.add(highMax);
        }
        // 대각선 빙고 가능 카운트 추가
        int diagonalR = 0;
        int diagonalL = 0;
        for(int i=1;i<6;i++){
            diagonalR = Math.max(diagonalR,map[i][i]);
            diagonalL = Math.max(diagonalL,map[6-i][i]);
        }
        pq.add(diagonalL);
        pq.add(diagonalR);
        int answer = 0;
        answer = Math.max(answer, pq.poll());
        answer = Math.max(answer, pq.poll());
        answer = Math.max(answer, pq.poll());
        System.out.println(answer);
    }

}
