package HiJaeYoung.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Num2309_일곱난장이 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> smalls = new ArrayList<>();
        for(int i=0;i<9;i++){
            smalls.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(smalls);
        sb = new StringBuilder();
        find(smalls,new ArrayList<>(),new boolean[9], 0,0);
        System.out.println(sb);
    }
    public static void find(List<Integer> smalls,List<Integer> tmp,boolean[] vist,int sum,int start){
        if(sum==100){
            sb = new StringBuilder();
            for(int num : tmp) {
                sb.append(num + "\n");
            }
        }
        for(int i=start;i<9;i++){
            if(!vist[i]){
                if(sum+smalls.get(i)<=100){
                    vist[i] = true;
                    tmp.add(smalls.get(i));
                    find(smalls,tmp,vist,sum+smalls.get(i),i+1);
                    vist[i] = false;
                    tmp.remove(tmp.size()-1);
                }
            }
        }

    }
}
