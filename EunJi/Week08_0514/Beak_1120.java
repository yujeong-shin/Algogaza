package EunJi.Week08_0514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();
        int answer = 0;
        if (B.length() == A.length()) {
            for (int i = 0; i < B.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    answer++;
                }
            }
        } else {
            answer = 50;
            for (int i = 0; i < B.length() - A.length() + 1; i++) {
                int temp = 0;
                for (int j = 0; j < A.length(); j++) {
                    if(B.charAt(i + j) != A.charAt(j)) {
                        temp = temp + 1;
                    }
                }
                if(answer > temp) answer = temp;
            }
        }
        System.out.println(answer);
    }


}

