import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Q1966_queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++) {
                q.offer(new int[] { j, Integer.parseInt(st.nextToken()) });
            }
            int count = 0;
            while (!q.isEmpty()) {
                int[] front = q.poll();
                boolean isMax = true;
                for(int j=0; j<q.size(); j++) {
                    if(front[1] < q.get(j)[1]) {
                        q.offer(front);
                        for(int k=0; k<j; k++) q.offer(q.poll());
                        isMax = false;
                        break;
                    }
                }
                if(!isMax) continue;
                count++;
                if(front[0] == M) {
                    break;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

}