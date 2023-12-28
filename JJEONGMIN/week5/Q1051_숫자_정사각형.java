import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q1051_숫자_정사각형 {
    static int N,M;
    static List<Integer> answer = new ArrayList<>();
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                isSquare(map[i][j], i, j);
            }
        }
        if(answer.isEmpty()){
            System.out.println(1);
        } else{
            answer.sort(Collections.reverseOrder());
            System.out.println(answer.get(0));
        }
    }
    private static void isSquare(int num, int h, int w){
        for(int i=w+1; i<M; i++){
            if(map[h][i] == num){
                int diff = i-w;
                if(h+diff<N && map[h+diff][w] == num && map[h+diff][i] == num)
                    answer.add((int)Math.pow(diff+1,2));
            }
        }
    }
}
