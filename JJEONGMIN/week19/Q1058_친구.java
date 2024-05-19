import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1058_친구 {
    static int[][] friendList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        friendList = new int[N][N];
        int[][] tempMap = new int[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j) == 'Y') friendList[i][j] = 1;
            }
        }

        for(int m=0; m<N; m++){
            for(int s=0; s<N; s++){
                if(m == s) continue;
                for(int e=0; e<N; e++){
                    if(s == e) continue;
                    if(friendList[s][m] == 1 && friendList[m][e] == 1) tempMap[s][e] = 1;
                    if(friendList[s][e] == 1 && friendList[e][s] == 1) tempMap[s][e] = 1;
                }
            }
        }

        int result = 0;
        for(int i=0; i<N; i++){
            int temp = 0;
            for(int j=0; j<N; j++){
                if(tempMap[i][j] == 1) temp++;
            }
            result = Math.max(result, temp);
        }
        System.out.println(result);
    }
}
