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
        for (int i = 0; i <ladderCount; i++) {
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
        boolean[] visited = new boolean[101];
        Q.add(num);
        int level=0;
        while (!Q.isEmpty()){
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int now = Q.poll();
                //94~99에서는 다음번에 무조건 100에 도달할 수 있음
                if(now>=94 && now<=99) {
                    //반복 중간에 찾아지면 한번 더 이동해야 100이 되기 때문에 +1
                    answer=++level;
                    return;
                }
                for (int diceNum = 1; diceNum <= 6; diceNum++) {
                    int next = now + diceNum;
                    if(!visited[next] && next<=100) {
                        visited[next]=true;
                        if(map.containsKey(next)) Q.add(map.get(next));
                        Q.add(next);
                    }
                }
            }
            level++;
        }
    }
}
