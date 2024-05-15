import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q12761_돌다리 {
    static int[] dp = new int[100001];
    static int cur;
    static int end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        cur = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[cur] = 0;
        // +1, -1, +A, -A, +B, -B, *A, *B
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        while(!queue.isEmpty()){
            int num = queue.poll();
            if(num == end) break;
            int[] arr = {num+1, num-1, num+A, num+B, num-A, num-B, num*A, num*B};
            for(int i=0; i<8; i++){
                int next = arr[i];
                if(next < 0 || next > 100000 || dp[next] != Integer.MAX_VALUE) continue;
                dp[next] = Math.min(dp[next], dp[num] + 1);
                queue.offer(next);
            }
        }
        System.out.println(dp[end]);
    }
}
