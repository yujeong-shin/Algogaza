import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피사노 주기 : 피보나치 수를 일정한 수 k로 나누면 반복
public class Q1904_01타일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];
        int result = 0;


        arr[1] = 1;
        arr[2] = 2;
        for(int i=3; i<=num; i++){
            arr[i] = (arr[i-1]+arr[i-2]) % 15746;
        }
        System.out.println(arr[num] % 15746);
    }
}
