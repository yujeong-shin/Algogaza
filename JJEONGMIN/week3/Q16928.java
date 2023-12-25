import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16928 {
    // 사다리의 수 : N, 뱀의 수 : M
    static int N, M, count = 0;
    // 주사위 칸 수 1~100
    static boolean[] arr = new boolean[101];
    // 연결되어 있는 두 수
    static int[] start_bridge, end_bridge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        start_bridge = new int[101];
        end_bridge = new int[101];
        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine());
            start_bridge[i] = Integer.parseInt(st.nextToken());
            end_bridge[i] = Integer.parseInt(st.nextToken());
        }
        bfs();
        System.out.println(count++);
    }
    private static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        arr[1] = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int cur = queue.poll();
                if(cur == 100) return;

                for(int j=6; j>=1; j--){
                    int next = cur + j;
                    if(next > 100 || arr[next]) continue;
                    else{
                        arr[next] = true;
                        queue.offer(check_bridge(next));
                    }
                }
            }
            count++;
        }
    }
    private static int check_bridge(int cur) {
        for(int i=0; i<start_bridge.length; i++){
            if(cur == start_bridge[i]) return end_bridge[i];
        }
        return cur;
    }
}
