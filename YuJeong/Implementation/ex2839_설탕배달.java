import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex2839_설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int cnt=0;

        while(true){
            if(n%5==0){
                System.out.println(n/5 + cnt);
                break;
            }else if(n<0){
                System.out.println(-1);
                break;
            }
            n -= 3;
            cnt++;
        }
    }
}
