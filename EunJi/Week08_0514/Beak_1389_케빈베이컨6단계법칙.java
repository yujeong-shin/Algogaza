package EunJi.Week08_0514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_1389_케빈베이컨6단계법칙 {
    static boolean[] visited;
    static int user = 0;
    static int friend = 0;
    static int[][] friends;
    static int[] answerArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        user = Integer.parseInt(st.nextToken());
        friend = Integer.parseInt(st.nextToken());
        visited = new boolean[user + 1];
        answerArr = new int[friend + 1];

        friends = new int[friend + 1][friend + 1];
        for (int i = 0; i < user; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(str.nextToken());
            int temp2 = Integer.parseInt(str.nextToken());
            friends[temp1][temp2] = 1;
            friends[temp2][temp1] = 1;
        }
        System.out.println("friends = " + Arrays.deepToString(friends));


        System.out.println(Arrays.toString(answerArr));
    }


}
