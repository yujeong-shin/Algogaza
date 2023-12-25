import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2839 {
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        answer = maroon5(N);
        if(N != 3 && N != 5 && answer == 1) answer = -1;
        System.out.println(answer);
    }
    private static int maroon5(int N){
        int num1 = N / 5;
        int num2 = N % 5;
        while(true){
            if(num1 == 0 && num2 % 3 != 0) return -1;
            if(num2 % 3 == 0) return num1 + (num2/3);
            else{
                num1--;
                num2 += 5;
            }
        }
    }
}
