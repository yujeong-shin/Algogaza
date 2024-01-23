import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

class Q_15654 {
    static int N;
    static int M;
    static BufferedWriter bw;
    static List<List<Integer>> list;
    static List<Integer> given;

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringTokenizer stForN = new StringTokenizer(sc.nextLine());
        given = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            given.add(Integer.parseInt(stForN.nextToken()));
        }
        Collections.sort(given); //sort in ascending order
        List<Integer> l = new ArrayList<>();
        list = new ArrayList<>();
        boolean[] visited = new boolean[N];
        dfs(l, visited);
        bw.flush();
        bw.close();
    }

    static void dfs(List<Integer> l, boolean[] visited) throws IOException {
        if (l.size() == M) {
            list.add(new ArrayList<>(l));
            for (int i = 0; i < l.size(); i++) {
                bw.write(l.get(i) + " ");
            }
            bw.write("\n");
        } else {

            for (int i = 0; i < given.size(); i++) {
                if (!visited[i]) {
                    visited[i]=true;
                    l.add(given.get(i));
                    dfs(l,visited);
                    l.remove(l.size() - 1);
                    visited[i]=false;
                }
            }
        }
    }
}
