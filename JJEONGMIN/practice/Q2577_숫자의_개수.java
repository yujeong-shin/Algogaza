import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2577_숫자의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;
        for(int i=0; i<3; i++){
            num *= Integer.parseInt(br.readLine());
        }
        int[] arr = new int[10];
        while(num != 0){
            int value = num % 10;
            arr[value]++;
            num /= 10;
        }
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
