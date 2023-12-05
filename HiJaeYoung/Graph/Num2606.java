import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num2606 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int computerNumber = Integer.parseInt(bf.readLine());
        int edge = Integer.parseInt(bf.readLine());
        List<List<Integer>> map = new LinkedList<>();
        StringTokenizer st;
        for(int i=0;i<=computerNumber;i++){
            map.add(new LinkedList<>());
        }
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(bf.readLine());
            int connect1 = Integer.parseInt(st.nextToken());
            int connect2 = Integer.parseInt(st.nextToken());
            map.get(connect1).add(connect2);
            map.get(connect2).add(connect1);
        }
        int virusCount = 0;
        boolean[] vist = new boolean[computerNumber+1];
        Arrays.fill(vist,false);
        Queue<Integer> que = new LinkedList<>();
        vist[1] = true;
        que.add(1);
        while(!que.isEmpty()){
            int nowComputer = que.poll();
            for(int nxt:map.get(nowComputer)){
                if(!vist[nxt]){
                    vist[nxt] = true;
                    virusCount++;
                    que.add(nxt);
                }
            }
        }
        System.out.println(virusCount);
    }
}
