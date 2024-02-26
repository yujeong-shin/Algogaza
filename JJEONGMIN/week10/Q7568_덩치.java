import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.List;

public class Q7568_덩치 {
    static List<Point> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int[] result = new int[N];
        Arrays.fill(result, 1);
        deongchichi(list, result);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
    private static void deongchichi(List<Point> list, int[] result){
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.size(); j++){
                if(i == j) continue;
                if(list.get(i).x < list.get(j).x && list.get(i).y < list.get(j).y)
                    result[i] += 1;
            }
        }
    }
}
