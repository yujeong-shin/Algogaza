// 숫자 정사각형

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1051 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int size = Math.min(n,m);

        while(size > 1) {
            for(int i=0; i<n-size+1; i++) {
                for(int j=0; j<m-size+1; j++) {
                    if(arr[i][j] == arr[i+size-1][j] && arr[i][j] == arr[i][j+size-1] && arr[i][j] == arr[i+size-1][j+size-1]){
                        System.out.println(size*size);
                        return;
                    }
                }
            }
            size--;
        }
        System.out.println(1);



    }
}