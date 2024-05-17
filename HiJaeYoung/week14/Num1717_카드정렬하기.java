package HiJaeYoung.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Num1717_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        while (pq.size()!=1){
            int tmp1 = pq.poll();
            int tmp2 = pq.poll();
            answer += tmp1 +tmp2;
            pq.add(tmp1+tmp2);
        }
        System.out.println(answer);
    }
}
