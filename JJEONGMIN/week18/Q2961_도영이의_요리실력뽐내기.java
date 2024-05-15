import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2961_도영이의_요리실력뽐내기 {
    static class Food{
        int bitter;
        int sour;
        public Food(int bitter, int sour){
            this.bitter = bitter;
            this.sour = sour;
        }
    }
    static List<Food> foods = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            foods.add(new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        bt(new ArrayList<>(), new boolean[N]);
        System.out.println(result);
    }
    public static void bt(List<Food> temp, boolean[] visited){
        if(temp.size() > 0){
            int mul = 1, sum = 0;
            for(int i=0; i<temp.size(); i++){
                mul *= temp.get(i).bitter;
                sum += temp.get(i).sour;
            }
            result = Math.min(result, Math.abs(mul-sum));
        }
        for(int i=0; i<foods.size(); i++){
            if(!visited[i]){
                temp.add(foods.get(i));
                visited[i] = true;
                bt(temp, visited);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }
    }
}
