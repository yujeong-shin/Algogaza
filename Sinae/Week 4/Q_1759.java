import java.io.*;
import java.util.*;

public class Q_1759 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        List<String> vowel = new ArrayList<>();
        List<String> consonant = new ArrayList<>();

        List<String> vowelSub = new ArrayList<>();
        List<String> consonantSub = new ArrayList<>();
        List<List<String>> vowelResult = new ArrayList<>();
        List<List<String>> consonantResult = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int c = 0; c < C; c++) {
            String read = st.nextToken();
            if (read.equals("a") || read.equals("e") || read.equals("i") ||
                    read.equals("o") || read.equals("u")) {
                vowel.add(read);
            } else {
                consonant.add(read);
            }
        }
        Collections.sort(vowel);
        boolean[] vowelVisited = new boolean[vowel.size()];
        boolean[] consonantVisited = new boolean[consonant.size()];
        for (int vowelCount = 1; vowelCount < L - 1; vowelCount++) {
            vowel_per(vowel, vowelVisited, vowelSub, vowelResult, vowelCount, 0, 0);
            consonant_per(consonant, consonantVisited, consonantSub, consonantResult, L - vowelCount, 0, 0);
        }
        List<List<String>> partial;
        List<List<List<String>>> res = new ArrayList<>();
        for (List<String> i : vowelResult) {
            for (List<String> j : consonantResult) {
                partial = new ArrayList<>();
                if (i.size() == L - j.size()) {
                    partial.add(i);
                    partial.add(j);
                } else {
                    continue;
                }
                res.add(partial);
            }
        }
        String s = "";

        List<List<String>> allList = new ArrayList<>();
        List<String> com;
        for (List<List<String>> r : res) {
            com = new ArrayList<>();
            for (List<String> rr : r) {
                for (int i = 0; i < rr.size(); i++) {
                    com.add(rr.get(i));
                }

            }
            Collections.sort(com);
            allList.add(com);
        }

        StringBuilder sb;
        List<String> answer = new ArrayList<>();
        for (List<String> a : allList) {
            sb = new StringBuilder();
            for (String aa : a) {
                sb.append(aa);
            }
            answer.add(sb.toString());
        }
        Collections.sort(answer);
        for (String answers : answer) {
            System.out.println(answers);
        }
    }

    public static void vowel_per(List<String> vowel, boolean[] vowelVisited, List<String> vowelSub,
                                 List<List<String>> vowelResult, int limit, int vowelCount, int start) {
        if (vowelCount == limit) {
            vowelResult.add(new ArrayList<>(vowelSub));
        } else {
            for (int i = start; i < vowel.size(); i++) {
                vowelSub.add(vowel.get(i));
                vowel_per(vowel, vowelVisited, vowelSub, vowelResult, limit, vowelCount + 1, i + 1);
                vowelSub.remove(vowelSub.size() - 1);
            }
        }
    }

    public static void consonant_per(List<String> consonant, boolean[] consonantVisited, List<String> consonantSub,
                                     List<List<String>> consonantResult, int limit, int consonantCount, int start) {
        if (consonantCount == limit) {
            consonantResult.add(new ArrayList<>(consonantSub));
            return;
        } else {
            for (int i = start; i < consonant.size(); i++) {
                consonantSub.add(consonant.get(i));
                consonant_per(consonant, consonantVisited, consonantSub, consonantResult, limit, consonantCount + 1, i + 1);
                consonantSub.remove(consonantSub.size() - 1);
            }
        }
    }
}