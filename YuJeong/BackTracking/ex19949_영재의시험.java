import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex19949_영재의시험 {
    static int[] answer, count, submit;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = new int[11];
        submit = new int[11];
        count = new int[6];
        for (int i = 1; i <= 10; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0);
        System.out.println(res);
    }
    static void DFS(int L) {
        if (L == 10) {
            int count = 0;
            for (int i = 1; i <= 8; i++) {
                if (submit[i] == submit[i + 1] && submit[i] == submit[i + 2]) {
                    return; // 3개의 연속된 답이 같다면 조건을 만족하지 않음
                }
            }
            for (int i = 1; i <= 10; i++) {
                if (answer[i] == submit[i]) count++;
            }
            if (count >= 5) res++;
        } else {
            for (int i = 1; i <= 5; i++) {
                submit[L+1] = i;
                DFS(L + 1);
            }
        }
    }
}
