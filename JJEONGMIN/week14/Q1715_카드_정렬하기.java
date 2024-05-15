import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q1715_카드_정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            pq.offer(Long.parseLong(br.readLine()));
        }

        long num = 0;
        while (pq.size() > 1) {
            long temp1 = pq.poll();
            long temp2 = pq.poll();

            num += temp1 + temp2;
            pq.add(temp1 + temp2);
        }
        System.out.println(num);
    }
}
