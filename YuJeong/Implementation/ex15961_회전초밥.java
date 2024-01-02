import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex15961_회전초밥 {
    static int n, d, k, c;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> sushi_list = new ArrayList<>();
        //맨 처음에 0부터 k개 값으로 answer 구하기
        for (int i = 0; i < k; i++) {
            sushi_list.add(sushi[i]);
        }
        answer = Math.max(answer, maxDiversity(sushi_list));

         for (int i = k; i < n + k - 1; i++) {
             sushi_list.add(sushi[i%n]);
             sushi_list.remove(0);

            answer = Math.max(answer, maxDiversity(sushi_list));
        }

        System.out.println(answer);
    }
    static int maxDiversity(List<Integer> sushi_list){
        Set<Integer> s = new HashSet<>();
        s.addAll(sushi_list);

        if(s.contains(c)) return s.size(); //쿠폰 초밥 먹은 경우
        else return s.size()+1;//쿠폰 초밥 먹지 않은 경우
    }
}