package HiJaeYoung;

import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 혹시 문제가 치사할 수 있으니까
        Long[] arr = new Long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int answer = 0;
        Loop1:
        for(int i=0;i<n;i++){
            if(arr[i] <= 0){
                int leftPoint = i+1;
                int rightPoint = n-1; // 자기 자신 바로 아래부터 시작헤야지
                while(leftPoint<rightPoint){
                    if(arr[leftPoint] + arr[rightPoint] > arr[i]){
                        rightPoint--;
                    }else if(arr[leftPoint] + arr[rightPoint] < arr[i]){
                        leftPoint++;
                    }else{
                        answer++;
                        continue Loop1;
                    }
                }
            }
            if(arr[i]>=0){
                int leftPoint = 0;
                int rightPoint = i-1; // 자기 자신 바로 아래부터 시작헤야지
                while(leftPoint<rightPoint){
                    if(arr[leftPoint] + arr[rightPoint] > arr[i]){
                        rightPoint--;
                    }else if(arr[leftPoint] + arr[rightPoint] < arr[i]){
                        leftPoint++;
                    }else{
                        answer++;
                        continue Loop1;
                    }
                }
            }
            // 0 0 0 인경우에는..?
            int leftPoint = 0;
            int rightPoint = n-1;
            while(leftPoint<i && rightPoint>i){
                if(arr[leftPoint] + arr[rightPoint] > arr[i]){
                    rightPoint--;
                }else if(arr[leftPoint] + arr[rightPoint] < arr[i]){
                    leftPoint++;
                }else{
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
