package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int n = Integer.parseInt(input);
        int m = 0;

        if(n <= 99) m = n;
        else {
            m = 99;
            for(int i=100; i<=n; i++) {
                int[] arr = new int[3];
                arr[2] = i%10;
                arr[1] = (i / 10)%10;
                arr[0] = i / 100;;
                if(arr[2] - arr[1] == arr[1] - arr[0]) m += 1;
            }
        }
        System.out.println(m);
    }
}
