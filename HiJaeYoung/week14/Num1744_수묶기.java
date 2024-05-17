package HiJaeYoung.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Num1744_수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            int nowInt = Integer.parseInt(br.readLine());
            if(nowInt>0){
                maxQ.add(nowInt);
            }else{
                minQ.add(nowInt);
            }
        }
        int answer = 0;
        int lastPlusValue =  1001,lastMinusValue=1001;
        while(!maxQ.isEmpty()){
            if(maxQ.size()==1) {
                lastPlusValue = maxQ.poll();
                break;
            }
            int a = maxQ.poll();
            int b = maxQ.poll();
            answer += Math.max(a+b,a*b);
        }
        while(!minQ.isEmpty()){
            if(minQ.size()==1) {
                lastMinusValue = minQ.poll();
                break;
            }
            int a = minQ.poll();
            int b = minQ.poll();
            answer += Math.max(a+b,a*b);
        }
        if(lastPlusValue!=1001 && lastMinusValue!=1001){
            answer+=Math.max(lastPlusValue+lastMinusValue,lastPlusValue*lastMinusValue);
        }else{
            if(lastPlusValue!=1001){
                answer+=lastPlusValue;
            }
            if(lastMinusValue!=1001){
                answer+=lastMinusValue;
            }
        }

        System.out.println(answer);

    }
}
