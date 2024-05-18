import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q9237_이장님의_초대 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        int day = 1, result = 0;
        for(int i=0; i<N; i++){
            result = Math.max(result, ++day + pq.poll());
        }
        System.out.println(result);
    }
}
