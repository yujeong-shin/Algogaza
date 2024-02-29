import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1436_영화감독숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int num = 666;
        while(true){
            // num의 길이를 세서 666이 있다면 count++
            // count==N이 되는 순간 print(num)
            String numStr = String.valueOf(num);
            if(numStr.contains("666")) count++;
            if(count == N) break;
            num++;
        }
        System.out.println(num);
    }
}