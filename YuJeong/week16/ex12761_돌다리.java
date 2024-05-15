import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class StoneDari {
    int number;
    int count;
    StoneDari(int number, int count){
        this.number = number;
        this.count = count;
    }
}
public class ex12761_돌다리 {
    static int A, B, N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        BFS();
    }
    public static void BFS() {
        boolean[] visited = new boolean[100001];
        Deque<StoneDari> deque = new ArrayDeque<>();
        deque.add(new StoneDari(N, 0)); // 현재 위치와 이동 횟수를 함께 저장
        visited[N] = true;

        while (!deque.isEmpty()) {
            StoneDari cur = deque.poll();
            int curNum = cur.number;
            int curCnt = cur.count;

            if (curNum == M) {
                System.out.println(curCnt);
                return;
            }

            // 이동 가능한 8가지 위치들
            int[] moves = {curNum + 1, curNum - 1, curNum + A, curNum - A, curNum + B, curNum - B, curNum * A, curNum * B};
            for (int next : moves) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    deque.add(new StoneDari(next, curCnt+1));
                }
            }
        }
    }
}
