import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex3980_선발명단 {
    static int[][] map;
    static boolean[] checked;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[11][11];
        checked = new boolean[11];

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            max = Integer.MIN_VALUE;
            DFS(0, 0);
            System.out.println(max);
        }
    }
    static void DFS(int person, int sum) {
        if(person==11){
            max = Math.max(max, sum);
            return;
        }
        else {
            for (int i = 0; i < 11; i++) {
                if(map[person][i] > 0) {
                    if(!checked[i]) {
                        checked[i]=true;
                        DFS(person+1, sum + map[person][i]);
                        checked[i]=false;
                    }
                }
            }
        }
    }
}
