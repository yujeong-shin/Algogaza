import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex1051_숫자정사각형 {
    static int n, m;
    static int[][] square;
    static int answer=1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        square = new int[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                square[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }
//        n과 m 중 최솟값이 정사각형 한 변의 길이 최댓값으로 가질 수 있다
        int minNum = Math.min(n, m);
        if(minNum==1) { //1이면 어차피 정답 1
            System.out.println(answer);
        }else System.out.println(findSquareArea(minNum));
    }

    static int findSquareArea(int minNum){
        for (int len = 2; len <= minNum; len++) { //정사각형 한 변의 길이를 가장 작은 수로 제한
            for (int i = 0; i <= n-len; i++) { //행 접근 가능 범위
                for (int j = 0; j <= m-len; j++) { //열 접근 가능 범위
                    if(  square[i][j] == square[i][j+(len-1)] && //꼭짓점에 있는 수가 모두 같다면
                            square[i][j+(len-1)] == square[i+(len-1)][j] &&
                            square[i+(len-1)][j] == square[i+(len-1)][j+(len-1)]  ){
                        answer=len*len; //넓이 담아주기~
                    }
                }
            }
        }
        return answer;
    }
}
