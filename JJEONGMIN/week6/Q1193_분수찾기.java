import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1193_분수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());

        // 등차수열 공식을 이용해 분자+분모 합의 근사값 구하기
        int num, n = 1;
        while(true){
            num = n*(n+1)/2;
            if(num >= X) break;
            n++;
        }
        // a : 분자, b : 분모
        int a = 0, b = 0;
        if(n % 2 == 0){
            a = n; b = 1;
            while(num != X){
                a--; b++; num--;
            }
        } else {
            a = 1; b = n;
            while(num != X){
                a++; b--; num--;
            }
        }
        StringBuilder sb = new StringBuilder(a + "/" + b);
        System.out.println(sb.toString());
    }
}
