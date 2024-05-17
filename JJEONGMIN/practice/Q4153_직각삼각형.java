import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4153_직각삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0 && c == 0) break;
            if(c>=b && c>=a && (a*a)+(b*b) == c*c) sb.append("right").append("\n");
            else if(b>=a && b>=c && (a*a)+(c*c) == b*b) sb.append("right").append("\n");
            else if(a>=b && a>=c && (c*c)+(b*b) == a*a) sb.append("right").append("\n");
            else sb.append("wrong").append("\n");
        }
        System.out.println(sb);
    }
}
