import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, result = Integer.MAX_VALUE;
        int sum = arr[0];
        while(end < N){
            if(sum >= S){
                result = Math.min(result, end-start+1);
                sum -= arr[start];
                start++;
            } else{
                end++;
                sum += arr[end];
            }
        }
        if(result == Integer.MAX_VALUE) result = 0;
        System.out.println(result);
    }
}
