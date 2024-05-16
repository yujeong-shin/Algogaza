package HiJaeYoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1389_베이컨_6단계 {
    private static class Answer{
        int point;
        int cbNumber;
        Answer(int point, int cbNumber){
            this.point =point;
            this.cbNumber = cbNumber;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Set<Integer>> map = new ArrayList<>();
        for(int i=0;i<n;i++){
            map.add(new HashSet<>());
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            map.get(num1-1).add(num2-1); // 중복체킹을해줄까?
            map.get(num2-1).add(num1-1);

        }
        int[] visted = new int[n];
        Queue<Integer> que = new LinkedList<>();
        Answer answer = new Answer(0,Integer.MAX_VALUE);
        for(int i=0; i<n; i++){
            int cbNumber = 0;
            Arrays.fill(visted,-1);
            visted[i] = 0;
            que.add(i);
            while(!que.isEmpty()){
                int point = que.poll();
                for(int nextPoint : map.get(point)){
                    if(visted[nextPoint]==-1){
                        visted[nextPoint] = visted[point]+1;
                        cbNumber+=visted[nextPoint];
                        que.add(nextPoint);
                    }
                }
            }
//            System.out.println(Arrays.toString(visted));
            if(answer.cbNumber>cbNumber){
                answer.point = i;
                answer.cbNumber = cbNumber;
            }else if(answer.cbNumber==cbNumber){
                answer.point = Math.min(i,answer.point);
            }
        }
        System.out.println(answer.point+1);
    }
}
