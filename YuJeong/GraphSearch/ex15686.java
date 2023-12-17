import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ex15686 {
    static int n, m, answer=Integer.MAX_VALUE;
    static List<Point> house, chicken;
    static int[] combi;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num==1) house.add(new Point(i, j));
                if(num==2) chicken.add(new Point(i, j));
            }
        }
        combi = new int[m];
        DFS(0,0);
        System.out.println(answer);
    }

    static void DFS(int L, int s){ //L : level, s : start
        if(L==m){
            int sum=0;
            for(Point h : house) {
                int dis = Integer.MAX_VALUE;
                for(int i : combi) { // i : m개만큼 고른 치킨집의 인덱스
                    //각 집과 가장 가까운 치킨집 사이의 거리 = 각 집의 치킨거리
                    dis = Math.min(dis, Math.abs(h.x-chicken.get(i).x)+Math.abs(h.y-chicken.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        }
        else {
            for (int i = s; i < chicken.size(); i++) {
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }
}
