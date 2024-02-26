import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1057_토너먼트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int hansu = Integer.parseInt(st.nextToken());
        int round = 1;

        while(true){
            if(isOdd(jimin)){
                if(jimin + 1 == hansu) break;
            }
            if(isOdd(hansu)){
                if(hansu + 1 == jimin) break;
            }
            jimin = nextNumber(jimin);
            hansu = nextNumber(hansu);
            round++;
        }
        System.out.println(round);
    }
    private static int nextNumber(int num){
        if(num % 2 == 0){
            return num / 2;
        } else return (num / 2) + 1;
    }
    private static boolean isOdd(int num){
        return num % 2 != 0;
    }
}
