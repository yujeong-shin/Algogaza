import java.io.*;
import java.util.StringTokenizer;

public class Q2293_동전_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] price = new int[K+1];
        int[] coins = new int[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }

        price[0] = 1;
        for(int coin : coins){
            for(int i=0; i<K; i++){
                if(i-coin < 0)continue;
                price[i] += price[i - coin];
            }
        }
        System.out.println(price[K]);
    }
}
