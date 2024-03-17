import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2193_이친수 {
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        arr = new long[num+1];
        System.out.println(twochinsu(num));
    }
    private static long twochinsu(int num){
        if(num == 1) return 1;
        if(num == 2) return 1;
        if(arr[num] != 0) return arr[num];
        return arr[num] = twochinsu(num-1) + twochinsu(num-2);
    }
}
