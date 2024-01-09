package BoSeok.Week5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class java_2933_미네랄 {
    static String filePath = "/Users/song/Desktop/Github/Algogaza/input";
    static int r, c,n ;
    static int[][] move = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static int flag = -1;
    static String[][] graph;
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bf = new BufferedReader(new BufferedReader(fileReader));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        graph = new String[r][c];
        for (int i = 0; i < r; i++) {
            stk = new StringTokenizer(bf.readLine());
            String row = stk.nextToken(); // ccp
            for (int j = 0; j < c; j++) {
                graph[i][j] = String.valueOf(row.charAt(j));
            }
        }
        n = Integer.parseInt(bf.readLine());
        StringTokenizer stk2 = new StringTokenizer(bf.readLine());

        List<Integer> lst = IntStream.rangeClosed(0, n-1)
                .mapToObj(i->Integer.parseInt(stk2.nextToken()))
                .collect(Collectors.toList());

//        하고 있는데 한화시스템에 언어 무관 이슈로 중지.
    }
}
