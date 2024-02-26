package HiJaeYoung.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num15665_N과M11 {
    static List<Integer> answers;
    static List<Integer> numbers;
    static HashSet<String> set;
    // 방문 쳌
    static boolean[] vist;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        answers = new LinkedList<>();
        numbers = new ArrayList<>();
        set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(numbers);
        sb = new StringBuilder();
        vist = new boolean[n];
        makeAnswers(n,m);
        System.out.println(sb.toString());
    }
    public static void makeAnswers(int n ,int m){
        if(answers.size()==m){
            if(set.contains(answers.toString())){
                return;
            }
            set.add(answers.toString());
            for(int value : answers){
                sb.append(value+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<n;i++){
            answers.add(numbers.get(i));
            vist[i] = true;
            makeAnswers(n, m);
            answers.remove(answers.size() - 1);
            vist[i] = false;
        }
    }
}
