import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1966_프린터_큐_for_풀이중 {
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
        int second_index = getIndex(M);

        // M(구하려는 문서의 인덱스 값)과 그 다음의 중요도를 가진 문서 중 제일 마지막에 뽑히는 문서의 인덱스의 값 비교를 통한 연산
        if(M < second_index){
            for(int i=0; i<M; i++) if(deque.get(i) >= deque.get(M)) answer++;
            for(int i=M; i<second_index; i++) if(deque.get(i) > deque.get(M)) answer++;
            for(int i=second_index; i<deque.size(); i++) if(deque.get(i) >= deque.get(M)) answer++;
        }
        else{
            for(int i=0; i<M; i++) if(deque.get(i) >= deque.get(M)) answer++;
            for(int i=M; i<deque.size(); i++) if(deque.get(i) > deque.get(M)) answer++;
        }
        sb.append(answer).append("\n");
    }
    private static int getIndex(int M){
        int num = 0, index = 0;
        for(int i=0; i<deque.size(); i++){
            if(deque.get(M) < deque.get(i) && deque.get(i) < num){
                num = deque.get(i);
                index = i;
            } else if(deque.get(i) == num) index = i;
        }
        return index;
    }
}
