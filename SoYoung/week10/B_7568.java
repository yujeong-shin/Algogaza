package week10;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_7568 {
    static int [][] arr;
    static int [] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        result = new int[n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] =  Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++) {
            int count = 1;
            for(int j=0; j<n; j++) {
                if(i != j && arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    count++;
                }
            }
            result[i] = count;
        }

        for(int a : result) System.out.print(a + " ");
    }
}
