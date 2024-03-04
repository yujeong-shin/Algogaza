package HiJaeYoung.week8;

// 4<= n <= 10 , 1<= n.value <= 99
// 99999999999999999999 -> long or String
// permutation

// 만든 숫자를 체크하는 방법 -> HashSet을 사용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Num5568_카드놓기 {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        String[] numbers = new String[n];
        for(int i=0;i<n;i++){
            numbers[i] = br.readLine();
        }
        HashSet<String> set = new HashSet<>();
        boolean[] vist = new boolean[n];
        backtracking(n,k,numbers,set,vist,new ArrayList<String>());
        System.out.println(set.size());
    }
    public static void backtracking(int n,int k, String[] numbers, HashSet<String> set, boolean[] vist, List<String> nowCard){
        if(nowCard.size()==k){
            set.add(listToString(nowCard));
            return;
        }
        for(int i=0;i<n;i++){
            if(!vist[i]){
                vist[i] = true;
                nowCard.add(numbers[i]);
                backtracking(n,k,numbers,set,vist,nowCard);
                nowCard.remove(nowCard.size()-1);
                vist[i] = false;
            }
        }
    }
    public static String listToString(List<String> list){
        StringBuilder sb = new StringBuilder();
        for(String str:list){
            sb.append(str);
        }
        return sb.toString();
    }
}
