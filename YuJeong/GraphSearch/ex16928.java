import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex16928 {
    static int ladderCount, snakeCount, answer;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        ladderCount = Integer.parseInt(st.nextToken());
        snakeCount = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        for (int i = 0; i <ladderCount ; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.put(start, end);
        }
        for (int i = 0; i < snakeCount; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.put(start, end);
        }
        BFS(1);
        System.out.println(answer);
    }

    // 게임의 목표는 1번 칸에서 시작해서 100번 칸에 도착하는 것이다.
    // 사다리 : 칸 증가, 뱀 : 칸 감소
    // 100까지 도착하기 위해 굴려야 하는 주사위의 횟수는?
    static void BFS(int num){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(num);
        int level=0;
        while (!Q.isEmpty()){
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int now = Q.poll();
                if(now==100) {
                    answer=level;
                    return;
                }
                else {
                    for (int j = 1; j <= 6; j++) {
                        int next = now+j;
                        if(map.containsKey(next)) Q.add(map.get(next));
                    }
                }
            }
            level++;
        }
    }
}
