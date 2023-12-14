package HiJaeYoung.Graph.week2;
// 다중 케이스
// i <= 300 체스판이라며..ㅠ
// 나이트의 한 턴의 모든 움직임을 확인 = BFS
// 나이트의 움직임 나타내는 법
// map 없어도 되겠는데 > 중복이 너무 많아서 방문한 노드에 관한 처리가 필요함. n^8으로 늘어남 재앙
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num7562_knight {
    static int[] dx = {2,2,1,1,-2,-2,-1,-1}, dy ={1,-1,2,-2,1,-1,2,-2};
    static class Node{
        int x;
        int y;
        int cnt;
        Node(int y, int x,int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(bf.readLine());
        for(int i=0;i<testcase;i++){
            int boardSize = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            Node nowKnight = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
            st = new StringTokenizer(bf.readLine());
            Node target = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
            sb.append(BFS(boardSize,nowKnight,target)+"\n");
        }
        System.out.print(sb);
    }
    public static int BFS(int size,Node knight, Node target){
        boolean[][] vist = new boolean[size][size];
        Queue<Node> que = new LinkedList<>();
        que.add(knight);
        //못찾는 경우는 주어지지 않는다 (조건 없음)
        int cnt =0;
        while(true){
            Node now = que.poll();
            if(now.x==target.x && now.y==target.y){
                return now.cnt;
            }
            for(int i=0;i<8;i++){
                int nxtX = now.x +dx[i];
                int nxtY = now.y +dy[i];
                if(nxtX>=0 && nxtX<size && nxtY>=0 && nxtY<size){
                    if(!vist[nxtY][nxtX]){
                        que.add(new Node(nxtY,nxtX, now.cnt+1));
                        vist[nxtY][nxtX] = true;
                    }
                }
            }
        }
    }
}
