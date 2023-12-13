import java.io.*;
import java.util.*;

public class beak15650 {
    static int n,m; //m개 고르기
    static int check[];
    static void dfs(int start, int acc)
    {
        if (acc ==  m)
        {
            for (int i=0; i<m; i++)
                System.out.print(check[i] + " ");
            System.out.println();
            return;
        }

        for (int i=start; i <= n; i++)
        {
            check[acc] = i;
            dfs(i+1,acc+1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        check = new int[m];
//        System.out.println(Arrays.toString(check));

        dfs(1, 0);
    }
}
