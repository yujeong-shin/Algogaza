import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1193_분수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int n=0; //몇 번째 대각선인지 찾는 코드
        int cnt=0;
        while(cnt<X){
            n++;
            cnt=n*(n+1)/2;
        }

        int num = X-(n-1)*n/2;  //대각선에서 몇 번째 위치인지 찾는 코드
        //X-이전 대각선까지의 값의 개수

        int bunja, bunmo;
        if(n%2==0){
            bunja=1; bunmo=n; //1번째 칸에서 세기 시작
            for (int i = 0; i < num-1; i++) { //반복횟수 1감소시켜야 함
                bunja++;
                bunmo--;
            }
        }else{
            bunja=n; bunmo=1;
            for (int i = 0; i < num-1; i++) {
                bunja--;
                bunmo++;
            }
        }
        System.out.println(bunja+"/"+bunmo);
    }
}
