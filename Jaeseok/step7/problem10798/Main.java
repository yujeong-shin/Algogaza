package Jaeseok.step7.problem10798;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // HashMap을 선언하여 column 인덱스 별 값을 저장하는 용도로 사용한다.
        Map<Integer, List<Character>> map = new HashMap<>();
        int maxIndex = -1;

        try {
            for (int rowCount = 0; rowCount < 5; rowCount++) {
                char[] letters = br.readLine().toCharArray();

                // 더 이상 검색할 필요가 없는 상황을 대비해서 maxIndex를 사용한다.
                // 세로로 읽는 것이기 때문에, 가장 긴 글자의 길이까지만 순회하면 된다.
                maxIndex = Math.max(maxIndex, letters.length);

                for (int i = 0; i < letters.length; i++) {
                    // 만약 현재 인덱스에 ArrayList가 없다면 새로 생성한다.
                    // 있으면 기존에 value로 있던 ArrayList를 가져오고, 해당 ArrayList에 값을 더 추가하고 map을 업데이트한다.
                    List<Character> target = map.getOrDefault(i, new ArrayList<>());
                    target.add(letters[i]);
                    map.put(i, target);
                }
            }

            // 세로 읽기
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < maxIndex; i++) {
                List<Character> target = map.get(i);
                if (target != null) {
                    for (char ch : target) {
                        sb.append(ch);
                    }
                }
            }

            // 결과 출력
            bw.write(sb.toString());
            bw.flush();

            br.close();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
