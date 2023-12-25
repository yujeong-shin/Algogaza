package BoSeok.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class java_5430_AC {
    static int T;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            String word = bf.readLine();
            Deque<String> deque = new LinkedList<>();
            Deque<Integer> nums = new LinkedList<>();
    //        dequeue 선언, 단어 하나씩 추가.
            for (int j = 0; j < word.length(); j++) {
                deque.add(String.valueOf(word.charAt(j)));
            }
    //        배열 숫자 갯수.
            String n = bf.readLine();
            String words = bf.readLine();
//            [ 빼고, ] 빼고 ,기준으로 자름
            for (String s : words.substring(1, words.length() - 1).split(","))
                if (!s.equals(""))
                    nums.add(Integer.valueOf(s));

            System.out.println(ACC(nums, deque));
        }
    }

    static String ACC(Deque<Integer> nums, Deque<String> deque) {
        boolean is_revers = false; // 뒤집음 여부.
        for (String word : deque) {
            if (word.equals("R")) {
//                단어를 뒤집음 여부
                if (is_revers == false) is_revers = true;
                else is_revers = false;
            }
//            D 인경우
            else {
//                사이즈가 0이면 에러로 리턴
                if (nums.size() == 0) return "error";
                else {
                    // 뒤집은 상태이면 뒤에서 빼주고, 아니면 앞에서 빼준다.
                    if (is_revers == false) nums.pollFirst();
                    else nums.pollLast();

                }
            }
        }
//        시작 [ 넣고
        StringBuilder sb = new StringBuilder("[");
        while (!nums.isEmpty()) {
//            뒤집음 여부확인해서 넣어주고
            sb.append(is_revers ? nums.removeLast() : nums.removeFirst());
//            중간중간 , 넣어줌
            if (nums.size() != 0)
                sb.append(',');
        }
//        마무리 닫아주고
        sb.append(']');
//        돌려줌
        return sb.toString();
    }
}
