import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2253_점프 {
    static int N,M, count = 0;
    static int[] stones, smallList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        stones = new int[N+1];
        smallList = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int a = Integer.parseInt(st.nextToken());
            smallList[a] = 2;
        }
    }
    static int jump(int dis){
        count++;
        if(smallList[dis] == 2) {

        }
        return Math.min(jump(dis-1),jump(dis));
    }
}