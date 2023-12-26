import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;

public class Q15686_치킨_배달 {
    static int N,M, answer = Integer.MAX_VALUE;
    static List<Point> housePoint;
    static List<Point> chickenPoint, chooseChickenPoint;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        housePoint = new ArrayList<>();
        chickenPoint = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                String a = st.nextToken();
                if(a.equals("1")){
                    housePoint.add(new Point(i, j));
                } else if(a.equals("2")) {
                    chickenPoint.add(new Point(i, j));
                }
            }
        }
        visited = new boolean[chickenPoint.size()];
        chooseChickenPoint = new ArrayList<>(M);
        chooseChicken(0,0);
        System.out.println(answer);
    }

    private static void chooseChicken(int a, int count) {
        if(count == M) {
            int dis = distance(chooseChickenPoint);
            if(answer > dis) answer = dis;
            return;
        }
        int answer = 0;
        for(int i=a; i<chickenPoint.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                chooseChickenPoint.add(new Point(chickenPoint.get(i)));
                chooseChicken(i+1,count + 1);
                chooseChickenPoint.remove(chooseChickenPoint.size()-1);
                visited[i] = false;
            }
        }
    }

    private static int distance(List<Point> list){
        int distance = 0, dis_min = Integer.MAX_VALUE, sum = 0;
        for (Point point : housePoint) {
            for (Point value : list) {
                distance = Math.abs(value.x - point.x) + Math.abs(value.y - point.y);
                dis_min = Math.min(dis_min, distance);
            }
            sum += dis_min;
            dis_min = Integer.MAX_VALUE;
        }
        return sum;
    }
}
