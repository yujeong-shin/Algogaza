import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2748_피보나치_수_2 {
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        arr = new long[num+1];
        System.out.println(fibo(num));
    }
    private static long fibo(int num){
        if(num == 0) return 0;
        if(num == 1) return 1;
        if(arr[num] != 0) return arr[num];
        else return arr[num] = fibo(num-1) + fibo(num-2);
    }
}
