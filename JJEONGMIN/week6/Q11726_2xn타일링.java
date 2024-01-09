import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11726_2xn타일링 {
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        d = new int[n+1];
        System.out.println(fibo(n));
    }
    private static int fibo(int n){
        if(n == 1) return d[1] = 1;
        if(n == 2) return d[2] = 2;
        if(d[n] != 0) return d[n];
        for(int i=3; i<=n; i++){
            d[i] = ((fibo(i-1)%10007) + (fibo(i-2)%10007)) % 10007;
        }
        return d[n];
    }
}
