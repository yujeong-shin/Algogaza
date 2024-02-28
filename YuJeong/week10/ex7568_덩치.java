import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dungchi{
    int w;
    int h;
    Dungchi(int w, int h){
        this.w = w;
        this.h = h;
    }
}
public class ex7568_덩치 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Dungchi[] dungchis = new Dungchi[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dungchis[i] = new Dungchi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < N; i++) {
            int res = 1;
            for (int j = 0; j < N; j++) {
                if(dungchis[i].w < dungchis[j].w && dungchis[i].h < dungchis[j].h) res++;
            }
            sb.append(res);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
