import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1966_fix {
    static int answer = 1;
    static LinkedList<Integer> deque = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(!deque.isEmpty()){
                while(!deque.isEmpty()) deque.pop();
            }

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                deque.add(Integer.parseInt(st1.nextToken()));
            }
            answer = 1;
            checkOrder(N,M);
        }
        System.out.println(sb.toString());
    }
    private static void checkOrder(int N, int M) {
        int max = 0;
        int max_index = 0;  // M의 값보다 1높은 값의 인덱스
        for(int i=0; i<deque.size(); i++){
            if(max < deque.get(i)) max = deque.get(i);
            if(deque.get(M) > deque.get(i)){
                max_index = i;
            }
        }
        if(max == deque.get(M)) {
            sb.append("1").append("\n");
            return;
        }
        else if(M < max_index){
            for(int i=0; i<M; i++) if(deque.get(i) >= deque.get(M)) answer++;
            for(int i=M; i<max_index; i++) if(deque.get(i) > deque.get(M)) answer++;
            for(int i=max_index; i<deque.size(); i++) if(deque.get(i) >= deque.get(M)) answer++;
        }
        else{
            for(int i=0; i<M; i++) if(deque.get(i) >= deque.get(M)) answer++;
            for(int i=M; i<deque.size(); i++) if(deque.get(i) > deque.get(M)) answer++;
        }
        sb.append(answer).append("\n");
    }
}
