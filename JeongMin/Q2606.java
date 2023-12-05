// 1260 코드 참고해서 살짝 변형하니 풀림 EZ
import java.util.Scanner;

public class Q2606 {
    static int[][] treeArray;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int com = sc.nextInt();
        int num = sc.nextInt();

        treeArray = new int[com+1][com+1];
        for(int i = 0; i < num; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            treeArray[a][b] = 1;
            treeArray[b][a] = 1;
        }
        visited = new boolean[com + 1];
        dfs(1);

        System.out.println(count);
    }
    public static void dfs(int v) {
        visited[v] = true;

        for(int j = 1; j < treeArray.length; j++) {
            if(treeArray[v][j] == 1 && visited[j] == false) {
                count++;
                dfs(j);
            }
        }
    }
}
