import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6064_카잉_달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            Point cal1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point cal2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            int result = kaing(cal1, cal2);

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
    private static int kaing(Point kaingCal, Point resultCal){
        int diff = Math.abs(kaingCal.x - kaingCal.y);
        int kaingMinValue = Math.min(kaingCal.x, kaingCal.y);
        int kaingMaxValue = Math.max(kaingCal.x, kaingCal.y);
        int resultDiff = Math.abs(resultCal.x- resultCal.y);
        int result = 0, count = 0;
        if(!isPossible(diff, kaingMinValue, resultDiff)) return -1;

        for(int i=kaingMinValue; i > 0; i -= diff){
            if(i == resultDiff) break;
            count++;
        }

        if(resultCal.x < resultCal.y){
            return (count * kaingMinValue) + (resultCal.x - 1);
        } else{
            return -1;
        }
    }
    private static boolean isPossible(int diff, int kaingMin, int resultDiff){
        for(int i=kaingMin; i > 0; i -= diff){
            if(resultDiff == i) return true;
        }
        return false;
    }
}
