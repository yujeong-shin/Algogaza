package HiJaeYoung.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1436_영화감독 {
    // 5666 -> 6661 -> 6662 -> ...-> 6669 -> 7666
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 666;
        int answer =0;
        while(n>0){
            //System.out.println(start);
            if(String.valueOf(start).contains("666")){
                answer = start;
                n--;
            }
            start++;
        }
        System.out.println(answer);
    }
}
