package HiJaeYoung.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num19949_재영의시험 {
    static int answer;
    static int[] answers,result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answers = new int[11];
        result = new int[11];
        for(int i=1;i<11;i++){
            result[i] = Integer.parseInt(st.nextToken());
        }
        answer = 0;
        backTracking(1,0);
        System.out.println(answer);
    }
    public static void backTracking(int sols, int score){
        if(sols==11){
            if(score>=5){
                answer++;
            }
            return;
        }
        for(int i=1;i<6;i++){
            answers[sols] = i;
            if(!check(sols)){
                if(answers[sols]==result[sols]){
                    backTracking(sols+1,score+1);
                }else{
                    backTracking(sols+1,score);
                }
            }
        }
    }
    public static boolean check(int num){
        if(num<3){
            return false;
        }
        int now = answers[num];
        for(int i=num-1; i>=num-2;i--){
            if(answers[i]!=now){
                return false;
            }
        }
        return true;
    }
}
