import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1065_한수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(calc(N));
    }
    
    public static int calc(int N){
        int answer = N;
        if(N <= 99){
            return answer;
        }else{
            answer = 99;
            for (int i = 100; i <= N; i++) {
                int beak = i / 100;
                int sip = i % 100 / 10;
                int ill = i % 10;
                if((beak-sip)==(sip-ill)) answer++;
            }
        }
        return answer;
    }
}
