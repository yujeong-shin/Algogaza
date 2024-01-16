import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Q19949_영재의_시험 {
    static List<List<Integer>> young = new ArrayList<>();
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] answerArr = new int[10];

        for(int i=0; i<10; i++){
            answerArr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(new ArrayList<>());
        checkScore(answerArr);
        System.out.println(answer);
    }
    private static void dfs(List<Integer> list){
        if(list.size() > 2 && Objects.equals(list.get(list.size() - 1), list.get(list.size() - 2)) && Objects.equals(list.get(list.size() - 2), list.get(list.size() - 3))) return;
        if(list.size() == 10){
            young.add(new ArrayList<>(list));
            return;
        }
        for(int i=1; i<=5; i++){
            list.add(i);
            dfs(list);
            list.remove(list.size()-1);
        }
    }
    private static void checkScore(int[] arr){
        for(int i=0; i<young.size(); i++){
            int score = 0;
            for(int j=0; j<10; j++){
                if(arr[j] == young.get(i).get(j)) score++;
            }
            if(score >= 5) answer++;
        }
    }
}
