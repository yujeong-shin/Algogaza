import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5525_IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        char[] charArray = br.readLine().toCharArray();

        int answer = 0;
        int patternCnt = 0;
        for (int i = 1; i < M - 1; i++) {
            if (charArray[i - 1] == 'I' && charArray[i] == 'O' && charArray[i + 1] == 'I') {
                patternCnt++;
                if (patternCnt == N) {
                    patternCnt--;
                    answer++;
                }
                i++;
                } else patternCnt = 0;
            }
        System.out.println(answer);
    }
}
