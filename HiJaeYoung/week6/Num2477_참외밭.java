package HiJaeYoung.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num2477_참외밭 {
    private static class Node{
        int direct;
        int value;
        Node(int direct, int value){
            this.direct =direct;
            this.value = value;
        }

    }
    // 멋잇게 풀기 실패ㅠ
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int myLover = Integer.parseInt(bf.readLine());
        Deque<Node> dq = new LinkedList<>();
        StringTokenizer st;
        for(int i=0;i<6;i++){
            st = new StringTokenizer(bf.readLine());
            int direct = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            dq.addFirst(new Node(direct,value));
        }
        int emptyArea = 0;
        int high = 0;
        int wide = 0;
        while(emptyArea ==0){
            Node nowNode = dq.pollLast();
            if(nowNode.direct==4 && dq.peekLast().direct==1){
                emptyArea = nowNode.value * dq.peekLast().value;
                dq.pollLast();
                dq.pollLast();
                high = dq.pollLast().value;
                wide = dq.pollLast().value;
            }
            if(nowNode.direct==3 && dq.peekLast().direct==2){
                emptyArea = nowNode.value * dq.peekLast().value;
                dq.pollLast();
                dq.pollLast();
                high = dq.pollLast().value;
                wide = dq.pollLast().value;
            }
            if(nowNode.direct==1 && dq.peekLast().direct==3){
                emptyArea = nowNode.value * dq.peekLast().value;
                dq.pollLast();
                dq.pollLast();
                high = dq.pollLast().value;
                wide = dq.pollLast().value;
            }
            if(nowNode.direct==2 && dq.peekLast().direct==4){
                emptyArea = nowNode.value * dq.peekLast().value;
                dq.pollLast();
                dq.pollLast();
                high = dq.pollLast().value;
                wide = dq.pollLast().value;
            }
            dq.addFirst(nowNode);
        }
        int answer = ((wide*high) - emptyArea)*myLover;
        System.out.println(answer);
    }
}
