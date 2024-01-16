import java.util.*;
import java.io.*;

public class Q_15649 {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> given = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            given.add(i);
        }
        List<Integer> part = new ArrayList<>();
        visited = new boolean[N];
        List<List<Integer>> result = new ArrayList<>();
        permu(given, M, result, visited, part);
        for (List<Integer> r : result) {
            for (int i = 0; i < r.size(); i++) {
                bw.write(String.format("%d", r.get(i)));
//                System.out.print(r.get(i));
                if (i != r.size() - 1) {
                    bw.write(" ");
//                    System.out.print(" ");
                }
            }
//            System.out.println();
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static void permu(List<Integer> given, int M, List<List<Integer>> result,
                      boolean[] visited, List<Integer> part) {
        if (part.size() == M) {
            result.add(new ArrayList<>(part));
        } else {
            for (int i = 0; i < given.size(); i++) {
                if (!visited[i]) {
                    part.add(given.get(i));
                    visited[i] = true;
                    permu(given, M, result, visited, part);
                    visited[i] = false;
                    part.remove(part.size() - 1);
                }
            }
        }
    }

}