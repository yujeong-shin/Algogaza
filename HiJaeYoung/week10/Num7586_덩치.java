package HiJaeYoung.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num7586_덩치 {
    // 키 , 무게
    // 둘다 압도해야 등치가 크다
    // 입력 N 의 덩치 등수를 구해라
    // 덩치 등수는 자신보다 큰 덩치 사람 수의 오름차순으로 정한다
    private static class Man implements Comparable<Man> {
        int h;
        int w;
        int number;
        int betterThenMe;
        public Man(int number,int h, int w){
            this.number = number;
            this.h = h;
            this.w = w;
            this.betterThenMe = 0;
        }
        public void strongThenMe(Man other){
            if(this.h<other.h && this.w<other.w){
                this.betterThenMe++;
            }else if(this.h>other.h && this.w>other.w){
                other.betterThenMe++;
            }
        }
        @Override
        public int compareTo(Man o){
            return this.betterThenMe - o.betterThenMe;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Man[] mans = new Man[n];
        PriorityQueue<Man> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            mans[i] = new Man(i,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        for(int i=0;i<n-1;i++){
            for(int k = i+1;k<n;k++){
                mans[i].strongThenMe(mans[k]);
            }
        }
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(mans[i].betterThenMe+1+" ");
        }
        System.out.println(sb);
    }
}
