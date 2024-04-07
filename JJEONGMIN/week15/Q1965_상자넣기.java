import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1965_상자넣기 {
    static class Max{
        int num;
        int count;
        public Max(int num, int count){
            this.num = num;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] temp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 1;
        Arrays.fill(temp, 1);
        for(int i=1; i<arr.length; i++){
            for(int j = i-1; j>=0; j--){
                if(arr[i] > arr[j] && temp[i] <= temp[j]) {
                    temp[i] = temp[j] + 1;
                    if(max < temp[i]) max = temp[i];
                }
            }
        }
        System.out.println(max);
    }
}
