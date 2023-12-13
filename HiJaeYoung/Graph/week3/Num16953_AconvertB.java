package HiJaeYoung.Graph.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num16953_AconvertB {
    static int A,B;
    private static class Node{
        long value;
        int cnt;
        Node(long v, int c){
            this.value = v;
            this.cnt =c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        System.out.println(BFS());
    }
    public static int BFS(){
        Queue<Node> que = new LinkedList<>();
//        boolean[] vist 작아지는 경우가  없으니 boolean 없어도 가능하겠다!
        que.add(new Node(A,1));
        while (!que.isEmpty()){
            Node now = que.poll();
            if(now.value==B){
                return now.cnt;
            }
            if(now.value*2<=B){
                que.add(new Node(now.value*2, now.cnt+1));
            }
            if(add_one(now.value) <=B){
                que.add(new Node(add_one(now.value),now.cnt+1));
            }
        }
        return -1;
    }
    public static long add_one(long value){
        return (value*10)+1;
    }
}
