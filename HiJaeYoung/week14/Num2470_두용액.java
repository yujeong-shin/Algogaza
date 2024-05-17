package HiJaeYoung.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num2470_두용액 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int startPoint = 0;
        int endPoint = n-1;
        int rAnswer =0;
        int lAnswer =0;
        int value = Integer.MAX_VALUE;
        while (endPoint>startPoint){
            int nowValue = arr[startPoint]+arr[endPoint];
            if(nowValue <0){
                if(value>nowValue*(-1)){
                    value = nowValue*(-1);
                    lAnswer = arr[startPoint];
                    rAnswer = arr[endPoint];
                }
            }else{
                if(value>nowValue){
                    value = nowValue;
                    lAnswer = arr[startPoint];
                    rAnswer = arr[endPoint];
                }
            }
            if(nowValue==0) break;
            if(nowValue>0){
                endPoint--;
            }else{
                startPoint++;
            }
        }
        System.out.println(lAnswer+" "+rAnswer);
    }
}
