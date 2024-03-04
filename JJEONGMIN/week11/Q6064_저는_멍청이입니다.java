import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6064_저는_멍청이입니다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            Point cal1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point cal2 = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
            boolean check = false;

            for(int i = cal2.x; i < (cal1.x * cal1.y); i += cal1.x){
                if(i % cal1.y == cal2.y){
                    sb.append(i+1).append("\n");
                    check = true;
                    break;
                }
            }
            if(!check) sb.append(-1).append("\n");
        }
        System.out.println(sb);
    }
}
