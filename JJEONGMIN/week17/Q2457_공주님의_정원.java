import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;

public class Q2457_공주님의_정원 {
    static class Flower{
        LocalDate startDate;
        LocalDate endDate;
        public Flower(int startMonth, int startDay, int endMonth, int endDay){
            this.startDate = LocalDate.of(2024, startMonth, startDay);
            this.endDate = LocalDate.of(2024, endMonth, endDay);
        }
    }
    public static class CompareFlower implements Comparator<Flower> {
        @Override
        public int compare(Flower o1, Flower o2){
            if(o1.startDate.equals(o2.startDate)) return o2.endDate.compareTo(o1.endDate);
            return o1.startDate.compareTo(o2.startDate);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Flower> flowers = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            flowers.add(new Flower(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()))
            );
        }
        flowers.sort(new CompareFlower());
        LocalDate startDate = LocalDate.of(2024,3,1), endDate = LocalDate.of(2024,12,1), temp = LocalDate.MIN;
        int count = 0, n = 0;
        while(startDate.isBefore(endDate)){
            boolean isFlower = false;
            for(int i=n; i<N; i++){
                if(flowers.get(i).startDate.isAfter(startDate)) break;
                if(temp.isBefore(flowers.get(i).endDate)){
                    isFlower = true;
                    temp = flowers.get(i).endDate;
                }
            }
            if(isFlower) {
                startDate = temp;
                count++;
            } else break;
        }
        if(temp.isBefore(endDate)) System.out.println(0);
        else System.out.println(count);
    }
}
