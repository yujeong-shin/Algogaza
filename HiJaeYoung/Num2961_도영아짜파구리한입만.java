package HiJaeYoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2961_도영아짜파구리한입만 {
    private static class Ingredient{
        int sour;
        int bitter;
        Ingredient(int sour,int bitter){
            this.sour= sour;
            this.bitter = bitter;
        }
    }
    private static class Cook{
        int sumSour;
        int sumBitter;
        Cook(){
            this.sumBitter = 0;
            this.sumSour = 1;
        }
        public void add(Ingredient ingredient){
            sumSour *= ingredient.sour;
            sumBitter += ingredient.bitter;
        }
        public void minus(Ingredient ingredient){
            sumSour /= ingredient.sour;
            sumBitter -= ingredient.bitter;
        }
        public int interval(){
            return Math.abs(sumSour-sumBitter);
        }
    }
    static int n,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Ingredient[] arr = new Ingredient[n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());
            arr[i] = new Ingredient(sour,bitter);
        }
        answer = Integer.MAX_VALUE;
        combination(arr,0,new Cook(),new boolean[n]);
        System.out.println(answer);
    }
    public static void combination(Ingredient[] arr,int now,Cook cook,boolean[] vist){
        if(now == n){
            return;
        }
        for(int i=now ;i<n;i++){
            if(!vist[i]){
                vist[i] = true;
                cook.add(arr[i]);
                answer = Math.min(answer,cook.interval());
                combination(arr,now+1,cook,vist);
                cook.minus(arr[i]);
                vist[i] = false;
            }
        }
    }
}

