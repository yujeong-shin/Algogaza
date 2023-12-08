// 이 코드를 기반으로 정답이 뜨는건 좋은데 공간 복잡도와 시간 복잡도 성능이 정말 구리다,,
import java.util.Scanner;
public class Q11724 {
    static int treeArray[][];
    static boolean visited[];
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        treeArray = new int[n+1][n+1];
        for(int i = 0; i < m; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();

            treeArray[a][b] = 1;
            treeArray[b][a] = 1;
        }

        visited = new boolean[n+1];
        for(int i = 1; i < n+1; i++)
            if(visited[i] == false)
            {
                dfs(i);
                count++;
            }
        System.out.println(count);
    }
    private static void dfs(int v) {
        visited[v] = true;

        // 여기 조건을 좀 바꿔야할거 같은데 흐음,,,아닌가?아닌건가? 아닌게맞나? 아닌거같기도하고? 아닌게 맞네
        if(v == treeArray.length) return;

        for(int j = 1; j < treeArray.length; j++) {
            if(treeArray[v][j] == 1 && visited[j] == false) {
                dfs(j);
            }
        }
    }
}
