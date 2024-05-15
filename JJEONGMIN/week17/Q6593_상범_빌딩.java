import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q6593_상범_빌딩 {
    public static class Point{
        int L;
        int R;
        int C;
        int count;
        public Point(int L, int R, int C, int count){
            this.C = C;
            this.R = R;
            this.L = L;
            this.count = count;
        }
    }
    public static class PointComparator implements Comparator<Point> {
        @Override
        public int compare(Point o1, Point o2) {
            return o1.count - o2.count;
        }
    }
    static int[][] dx = {{0,0,1},{0,0,-1},{0,1,0},{0,-1,0},{1,0,0},{-1,0,0}};
    static Point start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if(L == 0 && R == 0 && C == 0) break;

            char[][][] map = new char[L][R][C];
            boolean[][][] visited = new boolean[L][R][C];
            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    String str =  br.readLine();
                    for(int k=0; k<C; k++){
                        map[i][j][k] = str.charAt(k);
                        if(str.charAt(k) == 'S') start = new Point(i, j, k, 0);
                        if(str.charAt(k) == 'E') end = new Point(i, j, k, 0);
                    }
                }
                br.readLine();
            }

            int result = bfs(map, visited, 0);

            if(result > 0) sb.append("Escaped in ").append(result).append(" minute(s).").append("\n");
            else sb.append("Trapped!").append("\n");
        }
        System.out.println(sb);
    }
    public static int bfs(char[][][] map, boolean[][][] visited, int count){
        PriorityQueue<Point> pq = new PriorityQueue<>(new PointComparator());
        pq.offer(start);

        while(!pq.isEmpty()){
            Point p = pq.poll();
            if(p.L == end.L && p.R == end.R && p.C == end.C) return p.count;
            for(int i=0; i<6; i++){
                int nextD = p.L + dx[i][0];
                int nextH = p.R + dx[i][1];
                int nextW = p.C + dx[i][2];

                if(nextD < 0 || nextH < 0 || nextW < 0 || nextD >= map.length || nextH >= map[0].length || nextW >= map[0][0].length || visited[nextD][nextH][nextW] || map[nextD][nextH][nextW] == '#') continue;
                visited[nextD][nextH][nextW] = true;
                pq.offer(new Point(nextD, nextH, nextW, p.count+1));
            }
        }
        return -1;
    }
}
