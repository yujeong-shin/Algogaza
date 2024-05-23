import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18110_solved_ac {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        Deque<Integer> deque = new LinkedList<>(list);
        float average = (float) (N * 0.15);
        int removeCount = rounding(average);

        for(int i=0; i<removeCount; i++){
            deque.pollFirst();
            deque.pollLast();
        }
        int size = deque.size(), sum = 0;
        while(!deque.isEmpty()){
            sum += deque.pollFirst();
        }
        System.out.println(rounding((float) sum / size));
    }
    public static int rounding(float num){
        return Math.round(num);
    }
}
