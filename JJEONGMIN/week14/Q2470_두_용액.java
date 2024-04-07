import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q2470_두_용액 {
    static List<Integer> liquidList = new ArrayList<>();
    static class Liquid{
        int min;
        int max;
        int sum;
        private Liquid(int min, int max){
            this.min = min;
            this.max = max;
            this.sum = Math.abs(min + max);
        };
        public void update(int min, int max){
            this.min = min;
            this.max = max;
            this.sum = Math.abs(min+max);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = Integer.MAX_VALUE;
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            liquidList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(liquidList);
        int left = 0;
        int right = N-1;
        Liquid liquid = new Liquid(liquidList.get(left), liquidList.get(right));
        while(left < right){
            int sum = liquidList.get(right) + liquidList.get(left);
            if(sum == 0) {
                liquid.update(liquidList.get(left), liquidList.get(right));
                break;
            }
            if(liquid.sum > Math.abs(sum)) liquid.update(liquidList.get(left), liquidList.get(right));
            if(sum < 0) left++;
            if(sum > 0) right--;
        }
        System.out.println(liquid.min + " " + liquid.max);
    }
}
