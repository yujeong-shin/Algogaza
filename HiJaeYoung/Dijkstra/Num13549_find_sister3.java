package HiJaeYoung.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//1. Recursion call을 이용
//2. Dijkstra 이용

public class Num13549_find_sister3 {
    private static class Loca implements Comparable<Loca>{
        int nowLoca;
        boolean isWarp;
        int cnt;
        Loca(int nowLoca,int cnt){
            this.cnt =cnt;
            this.isWarp = isWarp;
            this.nowLoca = nowLoca;
        }
        @Override
        public int compareTo(Loca o){
           if(this.cnt==o.cnt){
               return this.nowLoca-o.nowLoca;
            }else {
               return this.cnt - o.cnt;
           }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int nowLocation = Integer.parseInt(st.nextToken());
        int target  = Integer.parseInt(st.nextToken());
        int[] map = new int[200001];
        Arrays.fill(map,Integer.MAX_VALUE);
        map[nowLocation] = 0;
        System.out.println(Dijkstra(nowLocation,target,map));
    }
    public static int Dijkstra(int start, int target, int[] map){
        PriorityQueue<Loca> pq =new PriorityQueue<>();
        pq.add(new Loca(start,0));
        map[start] = 0;
        while (!pq.isEmpty()){
            Loca now = pq.poll();
            //System.out.println(now.nowLoca+" "+now.cnt);
            if(now.nowLoca == target){
                return now.cnt;
            }
            if(now.nowLoca*2<200000 && map[now.nowLoca*2] == Integer.MAX_VALUE){
                    pq.add(new Loca(now.nowLoca*2,now.cnt));
                    map[now.nowLoca*2] = now.cnt;
                if(now.nowLoca*2 == target){
                    return now.cnt;
                }
            }
            if(now.nowLoca+1<200000){
                if(map[now.nowLoca+1] ==Integer.MAX_VALUE){
                    pq.add(new Loca(now.nowLoca+1, now.cnt+1 ));
                    map[now.nowLoca+1] = now.cnt+1;
                }
            }
            if(now.nowLoca-1>=0){
                if(map[now.nowLoca-1] ==Integer.MAX_VALUE){
                    pq.add(new Loca(now.nowLoca-1, now.cnt+1 ));
                    map[now.nowLoca-1] = now.cnt+1;
                }
            }
        }

        return -1;
    }
}
