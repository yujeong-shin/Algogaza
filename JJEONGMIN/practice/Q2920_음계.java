import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2920_음계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        String answer = "";
        for(int i=0; i<8; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i)+1 == list.get(i+1)) {
                answer = "ascending";
            }
            else if(list.get(i)-1 == list.get(i+1)) {
                answer = "descending";
            }
            else {
                answer = "mixed";
                break;
            }
        }
        System.out.println(answer);
    }
}
