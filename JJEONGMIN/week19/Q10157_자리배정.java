import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10157_자리배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(br.readLine());

        if((W*H) < order) {
            System.out.println(0);
            return;
        }

        boolean H_W_Switch = true; // true = 상하, false = 좌우
        boolean H_Switch = true; // true = 위, false = 아래
        boolean W_Switch = true; // true = 오른쪽, false = 왼쪽
        int maxHeight = H, resultH = 1;
        int maxWidth = W, resultW = 1;
        for(int i=1; i<order; i++){
            if(H_W_Switch){
                if(H_Switch){
                    if(++resultH == maxHeight) {
                        H_Switch = false;
                        H_W_Switch = false;
                    }
                } else {
                    if(--resultH == H - maxHeight + 1) {
                        maxHeight--;
                        H_Switch = true;
                        H_W_Switch = false;
                    }
                }
            } else {
                if(W_Switch){
                    if(++resultW == maxWidth) {
                        maxWidth--;
                        W_Switch = false;
                        H_W_Switch = true;
                    }
                } else {
                    if(--resultW == W - maxWidth + 1) {
                        W_Switch = true;
                        H_W_Switch = true;
                    }
                }
            }
        }
        System.out.println(resultW + " " + resultH);
    }
}
