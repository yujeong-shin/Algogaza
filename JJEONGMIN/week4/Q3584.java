import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3584 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            parents = new int[N+1];
            List<Integer> list = new ArrayList<>();

            for(int i=0; i<N-1; i++){
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                parents[B] = A;
            }
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            while(A != 0){
                list.add(A);
                A = parents[A];
            }

            while(B != 0){
                boolean check = false;
                for (Integer integer : list) {
                    if (B == integer) {
                        sb.append(integer);
                        check = true;
                        if(T >= 1) sb.append("\n");
                        break;
                    }
                }
                if(check) break;
                else B = parents[B];
            }
        }
        System.out.print(sb.toString());
    }
}
