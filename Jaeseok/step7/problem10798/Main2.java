package Jaeseok.step7.problem10798;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] words = new String[5];
        for (int i = 0; i < 5; i++) {
            words[i] = br.readLine();
        }

        // 최대 15개의 글자
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                // 만약 i보다 words[j]의 길이가 짧다면 j row에는 i번째 글자가 존재하지 않는 것이다.
                if (i < words[j].length()) {
                    bw.write(words[j].charAt(i));
                }
            }
        }

        br.close();
        bw.close();
    }
}
