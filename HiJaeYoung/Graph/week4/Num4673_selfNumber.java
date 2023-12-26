package HiJaeYoung.Graph.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num4673_selfNumber {
    static boolean[] selfNumber;
    public static void main(String[] args) {
        selfNumber = new boolean[10001];
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=10000;i++){
            if(!selfNumber[i]){
                sb.append(i+"\n");
                calculate(i);
            }
        }
        System.out.println(sb);
    }
    public static void calculate(int i){
      if(i>10000 ||selfNumber[i]){
          return;
      }
      selfNumber[i] =true;
      int nextNumber = i;
      for(char now : String.valueOf(i).toCharArray()){
          nextNumber += Character.getNumericValue(now);
      }
      calculate(nextNumber);
    }
}