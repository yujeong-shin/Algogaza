package HiJaeYoung.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num15649_M과N {
    // 길이가 m인 수열을 담는 list
    static List<Integer> answers;
    // 방문 쳌
    static boolean[] vist;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // Array보다는 Linked가 문제에 적합하다 생각해.
        answers = new LinkedList<>();
        sb = new StringBuilder();
        vist = new boolean[n+1];
        makeAnswers(n,m);
        System.out.println(sb.toString());
    }
    public static void makeAnswers(int n ,int m){
        if(answers.size()==m){
            for(int value : answers){
                sb.append(value+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=n;i++){
            if(!vist[i]){
                vist[i] = true;
                answers.add(i);
                makeAnswers(n,m);
                vist[i] = false;
                answers.remove(answers.size()-1);
            }
        }
    }
}
