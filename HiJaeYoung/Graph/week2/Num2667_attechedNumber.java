package HiJaeYoung.Graph.week2;

import java.io.*;
import java.util.*;

public class Num2667_attechedNumber {
    private static class Node{
        int h;
        int w;
        Node(int h,int w){
            this.h=h;
            this.w=w;
        }
    }
    static int[] dx ={1,-1,0,0} , dy={0,0,1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] map = new int[n][n];
        List<Node> targets = new LinkedList<>();
        boolean[][] vist = new boolean[n][n];
        for(int i=0;i<n;i++){
            int j =0;
            for(char now: bf.readLine().toCharArray()){
                int nowInt =Character.getNumericValue(now);
                map[i][j] = nowInt;
                if(nowInt==1){
                  targets.add(new Node(i,j));
                }
                j++;
            }
        }
        int numberOfTown =0;
        List<Integer> answerCount = new LinkedList<>();
        for(Node nowTarget : targets){
            if(!vist[nowTarget.h][nowTarget.w]){
                numberOfTown++;
                int answer = 0;
                Queue<Node> que = new LinkedList<>();
                que.add(nowTarget);
                vist[nowTarget.h][nowTarget.w] = true;
                while (!que.isEmpty()){
                    Node nowNode = que.poll();
                    answer++;
                    for(int i=0;i<4;i++){
                        if(nowNode.h+dy[i]>=0 && nowNode.h+dy[i]<n &&nowNode.w+dx[i] >=0 && nowNode.w+dx[i]<n){
                            if(map[nowNode.h+dy[i]][nowNode.w+dx[i]]==1 && !vist[nowNode.h+dy[i]][nowNode.w+dx[i]] ){
                                vist[nowNode.h+dy[i]][nowNode.w+dx[i]] = true;
                                que.add(new Node(nowNode.h+dy[i],nowNode.w+dx[i]));
                            }
                        }
                    }
                }
                answerCount.add(answer);
            }
        }
        System.out.println(numberOfTown);
        Collections.sort(answerCount);
        for(int answer : answerCount){
            System.out.println(answer);
        }

    }

}
