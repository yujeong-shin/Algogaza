import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15961_회전_초밥 {
    static List<Integer> list = new ArrayList<>();
    static Map<Integer, Integer> event = new HashMap<>();
    static int c, answer=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N : 접시의 수
        int N = Integer.parseInt(st.nextToken());
        // 최대 초밥의 번호
        int d = Integer.parseInt(st.nextToken());
        // 연속으로 먹을 접시 (탈출 조건)
        int k = Integer.parseInt(st.nextToken());
        // 쿠폰 번호
        c = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }
        for(int i=0; i<k; i++){
            event.put(list.get(i), event.getOrDefault(list.get(i), 0) + 1);
        }
        twoPointer(0, k-1);
        System.out.println(answer);
    }
    private static void twoPointer(int start, int end){
        while(start < list.size()){
            updateResult();
            event.put(list.get(start), event.getOrDefault(list.get(start), 0) - 1);
            if (event.get(list.get(start)) == 0) {
                event.remove(list.get(start));
            }
            start++;
            end++;
            if(end == list.size()) end = 0;
            event.put(list.get(end), event.getOrDefault(list.get(end), 0) + 1);
        }
    }
    public static void updateResult(){
        int size = event.size();
        if(!event.containsKey(c)) size++;
        answer = Math.max(answer, size);
    }
}

