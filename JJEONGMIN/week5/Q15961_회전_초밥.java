import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15961_회전_초밥 {
    static List<Integer> list = new ArrayList<>();
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
        for(int i=0; i<k-1; i++){
            list.add(list.get(i));
        }
        twoPointer(0, k-1);
        System.out.println(answer);
    }
    private static void twoPointer(int start, int end){
        Set<Integer> set = new HashSet<>();
        for(int i=start; i<end+1; i++){
            set.add(list.get(i));
        }
        int size = set.size();
        while(end != list.size()){

            if(!set.contains(c)) size++;
            answer = Math.max(answer, size);
            start++;
            end++;
        }
    }
}

