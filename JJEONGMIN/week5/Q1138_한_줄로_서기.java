import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1138_한_줄로_서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N : 사람의 수
        int N = Integer.parseInt(st.nextToken());
        int[] answer = new int[N];

        Queue<Integer> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            queue.offer(Integer.parseInt(st.nextToken()));
        }
        for(int i=1; i<N+1; i++){
            if(queue.isEmpty()) break;
            int num = queue.poll();
            int count = 0;
            for(int j=0; j<N; j++){
                if(answer[j] == 0){
                    count++;
                    if(count == num+1){
                        answer[j] = i;
                    }
                }
            }
        }
        for (int j : answer) {
            System.out.print(j + " ");
        }
    }
}
