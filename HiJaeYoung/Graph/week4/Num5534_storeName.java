package HiJaeYoung.Graph.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num5534_storeName {
    static String name;
    static String input;
    static int answer;
    static boolean find;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        answer = 0;
        name = bf.readLine();
        loop1:
        for(int i=0;i<n;i++){ // TC
            input = bf.readLine();
            //System.out.println(input);
            for(int k =0;(name.length()-1)*k+name.length()<=input.length();k++){ //간격 1부터 공식에 나온 간격까지
                for(int l =0;l+(name.length()-1)*k+name.length()-1<input.length();l++){
                    StringBuilder sb =new StringBuilder();
                    for(int h=0;h<name.length();h++){ //name의 글자 수 만큼 값을 더함
                        sb.append(input.charAt(l+(k+1)*h));
                    }
                    //System.out.println(sb);
                    if(sb.toString().equals(name)){
                        answer++;
                        continue loop1;
                    }
                }

            }
        }
        System.out.println(answer);
    }
}


