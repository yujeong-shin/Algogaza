import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Egg{
    int solidity;
    int weight;
    public Egg(int solidity, int weight) {
        this.solidity = solidity;
        this.weight = weight;
    }
}
public class ex16987_재영이는삼대오백 {
    static int N, answer;
    static Egg[] eggs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(s, w);
        }
        DFS(0, 0);
        System.out.println(answer);
    }

    static void DFS(int now, int count){
        if(now == N || count == N-1){ // 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란이거나, 깨지지 않은 다른 계란이 없는 경우
            answer = Math.max(answer, count);
            return;
        }
        if(eggs[now].solidity <= 0) { // 손에 든 계란이 깨진 경우
            DFS(now+1, count); // 가장 최근에 든 계란의 한 칸 오른쪽 계란을 손에 들고 반복
        }
        else { // 손에 든 계란이 깨지지 않은 경우, 모든 계란과 쳐보기
            for (int next = 0; next < N; next++) {
                if(now == next || eggs[next].solidity <= 0) { // 들고 있는 계란이거나, 깨진 계란이라면 패스
                    continue;
                }

                // 계란 치기
                eggs[now].solidity -= eggs[next].weight;
                eggs[next].solidity -= eggs[now].weight;

                // 계란 깨고 난 후 count 변화는?
                // 원본은 건드리지 말자.
                int curCnt = count;
                if(eggs[now].solidity <= 0) curCnt++;
                if(eggs[next].solidity <= 0) curCnt++;

                DFS(now+1, curCnt);

                // 백트래킹
                // 다른 경우에도 해당 계란 깰 수 있게 복구~!
                eggs[now].solidity += eggs[next].weight;
                eggs[next].solidity += eggs[now].weight;
            }
        }

    }
}
