package BoSeok.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class java_1966_프린터 {

    static ArrayList<Node> arr;
    static int t, n, m;

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
        /* @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }*/
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(bf.readLine()); // 4
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {

            String[] line = bf.readLine().split(" "); // 문서 갯수, 몇번째.
            int n = Integer.parseInt(line[0]); // 문서 갯수
            int target = Integer.parseInt(line[1]); // 찾으려는 숫자 인덱스
            int[] nodes = new int[n];

            line = bf.readLine().split(" ");
            arr = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                arr.add(new Node(j, Integer.parseInt(line[j])));
            }
            Node v = arr.get(target);
            System.out.println(solution(arr,v));
        }
    }

    private static int solution(ArrayList<Node> arr, Node v) {

        int idx = 0; // 정답

//        빌때까지 진행
        while (!arr.isEmpty()) {
//            쵀댓값
            int maxvalue = 0;
            for (Node node : arr) {
//                최댓값 갱신
                if (node.value > maxvalue) {
                    maxvalue = node.value;
                }
            }
//            맨 앞에있는값이 최댓값이면
            if (arr.get(0).value == maxvalue) {
//                최댓값인 노드 삭제.
                Node now = arr.remove(0);
//                터트린 횟수 업
                idx ++;
//                index 까지 비교하는 이유는 같은 숫자가 여러개면 안되기 때문이다.
                if (now.index == v.index && now.value ==v.value ) {
                    return idx;
                }
//                최댓값이 아니면
            }else {
//                뽑아다가
                Node now = arr.remove(0);
//                맨뒤로
                arr.add(now);
            }

        }
        return idx;
    }
}


// 덱은 get(i) 가 되지 않는다.

