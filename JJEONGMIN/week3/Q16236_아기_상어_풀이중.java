import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Q16236_아기_상어_풀이중 {
    static class BabyShark{
        Point point;
        int weight;
        int eatCount = 0;
        int movement = 0;
        boolean isUpgrade = false;
        public BabyShark(Point point, int weight){
            this.point = point;
            this.weight = weight;
        }
        public void moveShark(Point point, int count){
            this.point = point;
            this.movement += count;
        }
        public void eatFood(){
            this.eatCount++;
            if(this.eatCount == this.weight){
                this.weight++;
                this.eatCount = 0;
                isUpgrade = true;
            }
        }
    }
    static class Food{
        Point point;
        int weight;
        public Food(Point point, int weight){
            this.point = point;
            this.weight = weight;
        }
    }
    public static class FoodComparator implements Comparator<Food>{
        @Override
        public int compare(Food o1, Food o2) {
            if(o1.weight == o2.weight){
                if(o1.point.x==o2.point.x){
                    return o1.point.y - o2.point.y;
                }
                return o1.point.x - o2.point.x;
            }
            return o1.weight - o2.weight;
        }
    }
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BabyShark babyShark = null;
        PriorityQueue<Food> foodList = new PriorityQueue<>(1, new FoodComparator());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num == 9) babyShark = new BabyShark(new Point(i,j), 2);
                else if(num != 0) foodList.add(new Food(new Point(i,j), num));
            }
        }
        List<Food> foods = new ArrayList<>();
        while(!foodList.isEmpty()){
            Food food = foodList.poll();
            foods.add(food);
            if(!foodList.isEmpty() && foodList.peek().weight < babyShark.weight){
                continue;
            }
            if(food.weight>= babyShark.weight){
                break;
            }
            for(int i=0; i<foods.size(); i++){
                if(babyShark.isUpgrade) {
                    babyShark.isUpgrade = false;
                    continue;
                }
                findToNextFoodDistance(babyShark, foods.get(i));
            }
        }
    }
    public static void findToNextFoodDistance(BabyShark babyShark, Food food){
        int count = 1;
        int[] dh = {-1,0,0,1};
        int[] dw = {0,-1,1,0};
        boolean[][] visited = new boolean[N][N];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(babyShark.point));
        visited[babyShark.point.x][babyShark.point.y] = true;
        map[babyShark.point.x][babyShark.point.y] = 0;
        while(!queue.isEmpty()){
            Point point = queue.poll();
            for(int i=0; i<4; i++){
                int nextH = point.x + dh[i];
                int nextW = point.y + dw[i];
                if(nextH < 0 || nextW < 0 || nextH >= N || nextW >= N || map[nextH][nextW] > babyShark.weight || visited[nextH][nextW]) continue;
                if(nextH == food.point.x && nextW == food.point.y) {
                    babyShark.eatFood();
                    babyShark.moveShark(new Point(nextH, nextW), count);
                    return;
                }
                visited[nextH][nextW] = true;
                queue.offer(new Point(nextH, nextW));
            }
        }
    }
}
