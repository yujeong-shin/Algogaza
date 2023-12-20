package BoSeok.Week4;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class java_1759_암호만들기 {
    static int L, C;
    static ArrayList<String> arr = new ArrayList<>();
    static Stack<String> stk = new Stack<>();
    static ArrayList<String> word = new ArrayList<>(Arrays.asList("a","e", "i", "o", "u"));
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        L = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());

        String[] line = bf.readLine().split(" ");
        for (int j = 0; j < C; j++) {
            arr.add(line[j]);
        }

//        정렬
        Collections.sort(arr);
//        방탄 출발
        bt(0);
    }

    private static void bt(int idx) {

//        길이 만큼 만들었으면
        if (stk.size() == L) {

//            모음 자음 갯수 체크
            int a = 0;
            int b = 0;
//          모음 스트림형식만들고,         모음인것들 필터해서       카운트 세줌
            a += stk.stream().filter(x -> word.contains(x)).count();
            //자음
            b = L-a;

            if (a >= 1 && b >= 2) {
//                파이썬에서 "".join(str) 함수,  ["1","2","3","4"] >> 1234 로 출력 떄려버림
                String result = stk.stream().collect(Collectors.joining());
                System.out.println(result);
            }

        }
        for (int node = idx; node < C ; node++) {
            stk.add(arr.get(node));
            bt(node + 1);
            stk.pop();
        }
    }
}
