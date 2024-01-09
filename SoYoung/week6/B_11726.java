// 2xn 타일링

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[1001]; // n+1 -> n=1일 때 arr[2] 불가능
        arr[1] = 1;
        arr[2] = 2;

        for(int i=3; i<n+1; i++) {
            arr[i] = (arr[i-2] + arr[i-1]) % 10007; // 최종으로 나머지 연산을 한 결과값을 출력하려면 이전 연산시에도 나머지 연산을 해줘야 함
        }

        System.out.println(arr[n]);
    }
}
