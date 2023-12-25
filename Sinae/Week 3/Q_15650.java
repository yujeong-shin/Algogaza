import java.io.*;
import java.util.*;

public class Q_15650 {
    static boolean[] visited;
    static int[] num;
    static int[] arr;
    static int n;
    static int m;
    static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        num = new int[m];
        for (int i = 1; i <= n; i++) {
            arr[index++] = i;
        }
        recur(0);
    }

    public static void recur(int r) {
        if (r == m) {
            for (int z : num) {
                System.out.print(z + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    for(int j = 0; j < i; j++){
                        visited[j] = true;
                    }
                    visited[i] = true;
                    num[r] = arr[i];
                    recur(r + 1);
                    visited[i] = false;
                    for(int j = 0; j < i; j++){
                        visited[j] = false;
                    }
                }
            }
        }
    }
}