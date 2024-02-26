import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q2309_일곱_난쟁이 {
    static List<Integer> list = new ArrayList<>();
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
            sum += num;
        }
        Collections.sort(list);
        check();
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    private static void check(){
        int diff = sum - 100;
        for(int i=0; i<8; i++){
            int a = list.get(i);
            for(int j=1; j<9; j++){
                a += list.get(j);
                if(a == diff) {
                    list.remove(j);
                    list.remove(i);
                    return;
                } else a -= list.get(j);
            }
        }
    }
}
