import java.io.*;
import java.util.*;
public class Q2206 {
    static int H,W;
    static int[][] map;
    static boolean[][][] visited;
    static ArrayList<Integer> result;

    static class Node {
        int h;
        int w;
        int cnt;
        boolean destroyed;
        public Node(int h, int w, int cnt, boolean destroyed){
            this.h = h;
            this.w = w;
            this.cnt = cnt;
            this.destroyed = destroyed;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        result = new ArrayList<Integer>();

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[2][H][W];

        for(int i=0; i<H; i++){
            String str = br.readLine();
            for(int j=0; j<W; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0,0);
        br.close();
    }
    private static void bfs(int start_H, int start_W){
        int[] dx = {-1,0,0,1};
        int[] dy = {0,1,-1,0};

        Queue queue = new LinkedList<Integer>();
        queue.offer(new Node(start_H, start_W, 1, false));

        while(!queue.isEmpty()){
            Node now = (Node) queue.poll();
            if(now.h == H-1 && now.w == W-1){
                System.out.println(now.cnt);
                return;
            }
            for(int i=0; i<4; i++){
                int next_h = now.h + dy[i];
                int next_w = now.w + dx[i];
                if(next_h<0 || next_h>=H || next_w<0 || next_w>=W) continue;

                int next_cnt = now.cnt + 1;

                if(map[next_h][next_w] == 0){
                    if(!now.destroyed && !visited[0][next_h][next_w]){
                        queue.add(new Node(next_h,next_w,next_cnt,false));
                        visited[0][next_h][next_w] = true;
                    } else if(now.destroyed && !visited[1][next_h][next_w]){
                        queue.add(new Node(next_h,next_w,next_cnt,true));
                        visited[1][next_h][next_w] = true;
                    }
                }
                if(map[next_h][next_w] == 1){
                    if(!now.destroyed){
                        queue.add(new Node(next_h,next_w,next_cnt,true));
                        visited[1][next_h][next_w] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
