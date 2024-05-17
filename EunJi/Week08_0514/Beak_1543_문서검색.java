package EunJi.Week08_0514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak_1543_문서검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();

        int answer = 0;
        int documentIndex = 0;
        while (documentIndex + word.length() <= document.length()){
            boolean same = true;
            for (int i = 0; i < word.length(); i++) {
                if(word.charAt(i) != document.charAt(i + documentIndex)){
                    same = false;
                    documentIndex++;
                    break;
                }
            }
            if(same){
                documentIndex = documentIndex + word.length();
                answer++;
            }
        }
        System.out.println(answer);

    }
}
