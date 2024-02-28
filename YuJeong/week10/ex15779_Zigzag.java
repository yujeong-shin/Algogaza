import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex15779_Zigzag {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int max = Integer.MIN_VALUE;
        int count = 2;
        for (int i = 0; i < N-2; i++) {
            if(arr[i] <= arr[i+1] && arr[i+1] <= arr[i+2]) count=2;
            else if(arr[i] >= arr[i+1] && arr[i+1] >= arr[i+2]) count=2;
            else count++;
            max = Math.max(max, count);
            System.out.println("i = " + i);
            System.out.println("max = " + max);
        }
        System.out.println(max);
    }
}
