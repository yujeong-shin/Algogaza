import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex15961_회전초밥 {
    static int n, d, k, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] ch = new int[d + 1];

        // 초기 창 구성
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (ch[sushi[i]] == 0) {
                count++;
            }
            ch[sushi[i]]++;
        }
        int answer = count;

        // 슬라이딩 윈도우
        for (int i = k; i < n + k - 1; i++) {
            int rt = i % n;
            int lt = (i - k) % n;

            // rt 값 추가
            // 현재 0개일 때 추가할 때만 정답 값에 의미를 가짐
            if (ch[sushi[rt]] == 0) {
                count++;
            }
            ch[sushi[rt]]++;

            // lt 값 삭제
            // 현재 1개일 때 삭제할 때만 정답 값에 의미를 가짐
            if (ch[sushi[lt]] == 1) {
                count--;
            }
            ch[sushi[lt]]--;

            // 현재 구간에 쿠폰 초밥이 포함되어 있지 않으면 추가로 하나 더 세기
            if (ch[c] == 0) {
                answer = Math.max(answer, count + 1);
            } else {
                answer = Math.max(answer, count);
            }
        }

        System.out.println(answer);
    }
}