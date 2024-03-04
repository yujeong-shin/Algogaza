import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q15779_Ziqzaq {
    static int result = Integer.MIN_VALUE;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int count = 2;
        for(int i=0; i<N-2; i++){
            if(list.get(i) >= list.get(i+1) && list.get(i+1) >= list.get(i+2))
                count = 2;
            else if(list.get(i) <= list.get(i+1) && list.get(i+1) <= list.get(i+2))
                count = 2;
            else
                count++;
            result = Math.max(result, count);
        }
        System.out.println(result);
    }
}
