import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int answer = bfs(A,B);
        System.out.println(answer);
    }
    private static int bfs(int A, int B){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(A);
        int count = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int num = queue.poll();
                if(num == B) return count;
                else if(num > B) continue;
                else{
                    int a = num*2;
                    int b = (num*10)+1;
                    queue.offer(a);
                    queue.offer(b);
                }
            }
            count++;
        }
        return -1;
    }
}
