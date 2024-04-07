import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1744_수_묶기 {
    static List<Integer> tempList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> minusList = new ArrayList<>();
        List<Integer> plusList = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num < 0) minusList.add(num);
            else plusList.add(num);
        }
        minusList.sort(Collections.reverseOrder());
        Collections.sort(plusList);
        if(!minusList.isEmpty()){
            sum += maxInList(minusList);
        }
        if(!plusList.isEmpty()){
            sum += maxInList(plusList);
        }
        sum += sumTempList();

        System.out.println(sum);
    }
    public static int maxInList(List<Integer> list){
        int sum = 0;
        if(list.size() < 2){
            tempList.add(list.get(0));
            return sum;
        }
        if(!isOdd(list.size())){
            for(int i=0; i<list.size(); i+=2){
                if(checkSumOrMul(list.get(i), list.get(i+1))) {
                    tempList.add(list.get(i));
                    tempList.add(list.get(i+1));
                }
                else sum += list.get(i) * list.get(i+1);
            }
        } else{
            tempList.add(list.get(0));
            for(int i=1; i<list.size(); i+=2){
                if(checkSumOrMul(list.get(i), list.get(i+1))) {
                    tempList.add(list.get(i));
                    tempList.add(list.get(i+1));
                }
                else sum += list.get(i) * list.get(i+1);
            }
        }
        return sum;
    }
    public static int sumTempList(){
        int sum = 0;
        if(tempList.contains(0)) tempList.remove(tempList.get(0));
        for(int i=0; i<tempList.size(); i++){
            sum += tempList.get(i);
        }
        return sum;
    }
    public static boolean isOdd(int num){
        return num % 2 != 0;
    }
    public static boolean checkSumOrMul(int a, int b){
        return a + b > a * b;
    }
}
