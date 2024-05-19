import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18532_특정_거리의_도시_찾기 {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.get(A).add(B);
        }
        visited[x] = true;
        List<Integer> list1 = findCity(x, k);

        if(list1.isEmpty()) System.out.println(-1);
        else {
            Collections.sort(list1);
            for (Integer integer : list1) System.out.println(integer);
        }
    }
    public static List<Integer> findCity(int x, int k){
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> nextQueue = new LinkedList<>();
        queue.offer(x);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int neighbor : list.get(current)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        nextQueue.offer(neighbor);
                    }
                }
            }
            if (count == k) {
                return new ArrayList<>(nextQueue);
            }
            queue.addAll(nextQueue);
            nextQueue.clear();
        }
        return new ArrayList<>();
    }
}
