import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1417_국회의원_선거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dasom = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++){
            if(i == 0) dasom = Integer.parseInt(br.readLine());
            else pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while(!pq.isEmpty()){
            int integer = pq.poll();
            if(integer < dasom) continue;
            dasom++;
            answer++;
            integer--;
            if(integer >= dasom) pq.offer(integer);
        }
        System.out.println(answer);
    }
}
