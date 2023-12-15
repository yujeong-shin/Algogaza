import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex16953 {
    static int answer=-1;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        dfs(0, a, b);
        System.out.println(answer);
    }
    static void dfs(int L, long a, long b){
        if(a>b) return;
        if(a==b) answer=L+1;
        else {
            dfs(L+1, a*2, b);
            dfs(L+1, a*10+1, b);
        }
    }
}
