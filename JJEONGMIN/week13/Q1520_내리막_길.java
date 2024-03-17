import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1520_내리막_길 {
    static class Point {
        int h;
        int w;
        int count;
        public Point(int h, int w, int count){
            this.h = h;
            this.w = w;
            this.count = count;
        }
    }
    static class PointComparator implements Comparator<Point>{
        @Override
        public int compare(Point o1, Point o2) {
            return o2.count - o1.count;
        }
    }
    static int[][] map;
    static int[] dh = {0, 0, 1};
    static int[] dw = {-1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }
    private static int bfs(){
        int result = 0;
        PriorityQueue<Point> queue = new PriorityQueue<>(new PointComparator());
        queue.offer(new Point(0,0, 1));

        while(!queue.isEmpty()){
            Point p = queue.poll();
            int size = queue.size();
            for(int i=0; i<3; i++){
                int nextH = p.h + dh[i];
                int nextW = p.w + dw[i];
                if(nextH < 0 || nextW < 0 || nextH >= map.length || nextW >= map[0].length) continue;
                if(nextH == map.length-1 && nextW == map[0].length-1) result++;
                if(map[p.h][p.w] > map[nextH][nextW]){
                    if(queue.size() == size)
                        queue.offer(new Point(nextH, nextW, p.count));
                    else
                        queue.offer(new Point(nextH, nextW, p.count + 1));
                }
            }
        }
        return result;
    }
}
