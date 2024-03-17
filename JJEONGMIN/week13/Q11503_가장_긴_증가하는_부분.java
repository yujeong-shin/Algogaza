import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q11503_가장_긴_증가하는_부분 {
    static class Sequence{
        int curNumber;
        int count;
        public Sequence(int curNumber, int count){
            this.curNumber = curNumber;
            this.count = count;
        }
    }
    static List<Sequence> sequences = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 1;

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            sequences.add(new Sequence(Integer.parseInt(st.nextToken()), 1));
        }
        for(int i=0; i<sequences.size(); i++){
            for(int j=0; j<i; j++){
                if(sequences.get(i).curNumber > sequences.get(j).curNumber && sequences.get(j).count >= sequences.get(i).count) {
                    sequences.get(i).count = sequences.get(j).count + 1;
                    result = Math.max(sequences.get(i).count, result);
                }
            }
        }
        System.out.println(result);
    }
}
