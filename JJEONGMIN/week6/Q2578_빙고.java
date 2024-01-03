import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q2578_빙고 {
    static int[][] map = new int[5][5];
    static int Bingo = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 빙고판 생성
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
            }
        }

        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                int n = Integer.parseInt(st.nextToken());
                deque.offer(n);
            }
        }

        int answer = 0;
        while(!deque.isEmpty()){
            boolean flag = false;
            int num = deque.poll();
            answer++;
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(map[i][j] == num){
                        map[i][j] = 0;
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
            if(answer > 11) checkBingo();
            if(Bingo >= 3) break;
        }
        System.out.println(answer);
    }
    private static void checkBingo(){
        // 우 대각선
        Bingo = 0;
        int count = 0;
        for(int i=0, j=4; i<5; i++, j--) if(map[i][j] == 0) count++;
        plusBingo(count);
        // 좌 대각선
        count = 0;
        for(int i=0; i<5; i++) if(map[i][i] == 0) count++;
        plusBingo(count);
        // 세로
        for(int i=0; i<5; i++) {
            count = 0;
            for(int j=0; j<5; j++) if(map[i][j] == 0) count++;
            plusBingo(count);
        }
        // 가로
        for(int i=0; i<5; i++) {
            count = 0;
            for(int j=0; j<5; j++) if(map[j][i] == 0) count++;
            plusBingo(count);
        }
    }
    private static void plusBingo(int count) {
        if(count == 5) {
            Bingo++;
            return;
        }
    }
}
