package HiJaeYoung.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Num1065_한수 {
    static int answer;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        answer=0;
        for(int i=1;i<=n;i++){
            if(i<=10 || hanNum(i) ){
                answer++;
            }
        }
        System.out.println(answer);
    }
    public static boolean hanNum(int k){
        List<Integer> list = new ArrayList<>();
        while(k>0){
            list.add(k%10);
            k = k/10;
        }
        int gap =list.get(0) - list.get(1);
        for(int i=1;i< list.size()-1;i++){
            if(gap != list.get(i) - list.get(i+1)) return false;
        }
        return true;
    }
}
