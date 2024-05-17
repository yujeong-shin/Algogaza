package HiJaeYoung.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


public class Num30242_NQueenEasy {
    private static class Queen{
        int h;
        int w;
        Queen(int h, int w){
            this.h = h;
            this.w = w;
        }
        public boolean canAttack(int h, int w){
            if(Math.abs(h-this.h)+Math.abs(w-this.w)==1){
                return true;
            }
            if(Math.abs(w-this.w) == Math.abs(h-this.h)){
                return true;
            }
            return false;
        }
    }
    static int n;
    static int[] answer;
    static boolean[] isFix;
    static int[] vist;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        List<Queen> queens = new LinkedList<>();
        isFix = new boolean[n+1];
        vist = new int[n+1];
        // vist is Available queens count
        Arrays.fill(vist,n);
        answer = new int[n+1];
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++){
            int value = Integer.parseInt(st.nextToken());
            if(value!=0){
                // use to validate
                queens.add(new Queen(i,value));
                isFix[i] =true;
                vist[value] =1;
                // if put queens, calculate vist count
                calculate(i,value);
            }
        }
        DFS(queens,1);
        if(sb.toString().isEmpty()){
            System.out.println("-1");
        }else{
            System.out.println(sb);
        }

    }
    public static void calculate(int queenH, int queenW){
        for(int i=1;i<=n;i++){
            if(i == queenH) continue;
            // up and down
            vist[i] --;

            // diagonal
            if(Math.abs(i-queenH)+queenW<=n){
                vist[i] --;
            }
            if(queenW-Math.abs(queenH-i)>=1){
                vist[i]--;
            }
        }
    }
    public static void DFS(List<Queen> queens, int depth){
        if(!sb.toString().isEmpty()) return;
        if(queens.size()==n){
            for(Queen queen:queens){
                answer[queen.h] = queen.w;
            }
            for(int i :answer){
                if(i==0) continue;
                sb.append(i+" ");
            }
        }
        if(depth>n){
            return;
        }
        if(isFix[depth]) {
            DFS(queens,depth+1);
        }
        // find minimum vist value
        int minValue = Arrays.stream(vist).min().getAsInt();
        int index = 0;
        for(int i=1;i<=n;i++){
            if (minValue==vist[i]){
                index = i;
                break;
            }
        }



//        for(int i=1;i<=n;i++){
//            if(!vist[i]&&simulation(depth,i,queens)){
////                System.out.println(depth+" "+i);
////                System.out.println(Arrays.toString(vist));
//                queens.add(new Queen(depth,i));
//                vist[i] =true;
//                DFS(queens,depth+1);
//                queens.remove(queens.size()-1);
//                vist[i] =false;
//            }
//        }
    }
    public static boolean simulation(int h, int w, List<Queen> queens){
        for(Queen now:queens){
            if(now.canAttack(h,w)){
                return false;
            }
        }
        return true;
    }
}
