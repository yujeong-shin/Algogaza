package HiJaeYoung.Graph.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// LinkedList 의 remove 시간 복잡도가 항상 O(1)은 아님 근데 여기서는 O(1)에 가깝지 않나..
// deque가 빠르긴하구나
public class Num5430_AC {
    private static class AC{
        Deque<String> deque;
        boolean isRevers;
        int size;

        AC(Deque<String> deque,int size){
            isRevers = false;
            this.deque = deque;
            this.size = size;
        }
        public boolean add(Character now){
            if(now=='R'){
                if(isRevers){
                    isRevers = false;
                }else{
                    isRevers = true;
                }
            }else{
                if(size==0){
                    return false;
                }
                size -=1;
//                myList.remove(pointer);
                if(isRevers){
                    deque.pollLast();
                }else{
                    deque.pollFirst();
                }

            }
            return true;
        }
        @Override
        public String toString(){
            if(size==0){
                return "[]";
            }
            if(!isRevers){
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                for(int i=0;i<size;i++){
                    if(i==size-1){
                        sb.append(deque.pollFirst());
                        continue;
                    }
                    sb.append(deque.pollFirst()+",");
                }
                sb.append("]");
                return sb.toString();
            }

            return reversToString();
        }
        private String reversToString(){
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for(int i=size-1;i>=0;i--){
                if(i==0){
                    sb.append(deque.pollLast());
                    continue;
                }
                sb.append(deque.pollLast()+",");
            }
            sb.append("]");
            return sb.toString();
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        StringBuilder sb =new StringBuilder();
        StringTokenizer st;
        loop1 :
        for(int i=0;i<testCase;i++){
            char[] acArray = bf.readLine().toCharArray();
            int arrSize = Integer.parseInt(bf.readLine());
//            String input = bf.readLine();
//            String[] numberArr = input.substring(1,input.length()-1).split(",");
            st = new StringTokenizer(bf.readLine(), "[],");
            Deque<String> mylist = new LinkedList<>();
            for(int j=0;j<arrSize;j++){
                mylist.addLast(st.nextToken());
            }
            AC ac = new AC(mylist,arrSize);
            for(char nowAc : acArray){
                if(!ac.add(nowAc)){
                    sb.append("error"+"\n");
                    continue loop1;
                }
            }
            sb.append(ac.toString()+"\n");
        }
        System.out.println(sb);
    }
}
