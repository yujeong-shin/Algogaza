import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;

public class Q15686 {
    static int N,M, answer = 100;
    static List<Point> housePoint;
    static List<Point> chickenPoint, chooseChickenPoint;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


            housePoint = new ArrayList<>(2*N);
            chickenPoint = new ArrayList<>(M);

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
        chooseChicken(0);
        System.out.println(answer);
    }

    private static void chooseChicken(int count) {
        if(count == M) {
            answer = Math.min(answer, distance(chooseChickenPoint));
            return;
        }
        int answer = 0;
        for(int i=0; i<chickenPoint.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                chooseChickenPoint.add(new Point(chickenPoint.get(i)));
                chooseChicken(count + 1);
                visited[i] = false;
            }
        }
    }

    private static int distance(List<Point> list){
        int distance = 0, dis_min = 100, sum = 0;
        for(int i=0; i<housePoint.size(); i++){
            for(int j=0; j<list.size(); j++){
                distance = Math.abs(list.get(j).x-housePoint.get(i).x) + Math.abs(list.get(j).y-housePoint.get(i).y);
                dis_min = Math.min(dis_min, distance);
            }
            sum += dis_min;
        }
        return sum;
    }
}
