import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2253_점프 {
    static int N,M, count = 0;
    static int[] stones;
    static List<Integer> smallStone = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        stones = new int[20001];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            stones[a] = -1;
        }
        stones[1] = 0;
        stones[2] = 1;
        for(int i=0; i<=N; i++){

        }

        System.out.println(stones[N]);
    }
}
