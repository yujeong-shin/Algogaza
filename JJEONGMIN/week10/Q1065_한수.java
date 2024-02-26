import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1065_한수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        int num = Integer.parseInt(st.nextToken());
        for(int i=1; i<=num; i++){
            if(isHansoo(i)) result++;
        }
        System.out.println(result);
    }
    private static boolean isHansoo(int num){
        List<Integer> list = new ArrayList<>();
        while(num != 0){
            list.add(num % 10);
            num /= 10;
        }
        if(list.size() > 1){
            int d = list.get(1) - list.get(0);
            for(int i=0; i<list.size()-1; i++){
                if(list.get(i+1) != list.get(i) + d)return false;
            }
        }
        return true;

    }
}
