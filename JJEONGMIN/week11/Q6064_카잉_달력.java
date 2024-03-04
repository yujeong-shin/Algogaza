import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;

public class Q6064_카잉_달력 {
    static int result = 0;
    static List<Integer> diffList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            Point cal1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point cal2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            diffList.clear();
            result = kaing(cal1, cal2);

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
    private static int kaing(Point kaingCal, Point resultCal){
        int diff = Math.abs(kaingCal.x - kaingCal.y);
        int kaingMinValue = Math.min(kaingCal.x, kaingCal.y);
        int kaingMaxValue = Math.max(kaingCal.x, kaingCal.y);
        int resultMinValue = Math.min(resultCal.x, resultCal.y);
        int resultMaxValue = Math.max(resultCal.x, resultCal.y);
        int resultDiff = Math.abs(resultCal.x- resultCal.y);
        int count = 0;
        if(!isPossible(diff, kaingMinValue, resultDiff)) return -1;

        for(int i=kaingMinValue; i > 0; i -= diff){
            diffList.add(i);
        }

        if(Integer.signum(kaingCal.x - kaingCal.y) == Integer.signum(resultCal.x - resultCal.y)){
            if(kaingCal.x > kaingCal.y){
                count = diffList.indexOf(resultDiff)+1;
                return (count * kaingMinValue) + resultMinValue;
            } else {
                count = diffList.size() - diffList.indexOf(resultDiff);
                return (count * kaingMinValue) + resultMinValue;
            }
        } else {
            if(kaingCal.x > kaingCal.y){
                count = diffList.indexOf(resultDiff) + 1;
                return (count * kaingMaxValue) + resultMaxValue - 1;
            }
            count = diffList.size() - diffList.indexOf(resultDiff);
            return (count * kaingMaxValue) + resultMaxValue - 1;
        }
    }
    private static boolean isPossible(int diff, int kaingMin, int resultDiff){
        for(int i=kaingMin; i > 0; i -= diff){
            if(resultDiff == i) return true;
        }
        return false;
    }
}
