import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < testcases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] priorities = new int[N];
            for (int n = 0; n < N; n++) {
                priorities[n] = Integer.parseInt(st.nextToken());
            }

            Deque<List<Integer>> deq = new ArrayDeque<>();
            for (int p = 0; p < priorities.length; p++) {
                deq.add(new ArrayList<>(Arrays.asList(priorities[p], p)));
            }

            int count = 0;
            while (!deq.isEmpty()) {
                int max = findMax(deq);
                while (deq.peek().get(0) != max) {
                    List<Integer> moving = deq.removeFirst(); //remove and add to the last
                    deq.addLast(moving);
                }
                List<Integer> tobePolled = deq.poll();
                count++;
                if (tobePolled.get(1) == location) {
                    break;
                }
            }
            l.add(count);
        }
        for (int i : l) {
            System.out.println(i);
        }
    }

    static int findMax(Deque<List<Integer>> deq) {
        Deque<List<Integer>> copied = new ArrayDeque<>(deq);
        int max = Integer.MIN_VALUE;
        while (!copied.isEmpty()) {
            List<Integer> polled = copied.poll();
            max = Math.max(polled.get(0), max);
        }
        return max;
    }

}