package BoSeok.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class java_11033_최솟값찾기 {
    static int n,l;
    static LinkedList<Node> result = new LinkedList<Node>();
    static ArrayList<Integer> arr = new ArrayList<>();

// 슬라이딩윈도우 + deque  vs heapq 난 덱
// 힙으로도 될거같기도..


    //    각 숫자 index, value 저장.
    static class Node{
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        l = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            arr.add(Integer.valueOf(stk.nextToken()));
        }
        System.out.println("arr = " + arr);
//        처음부터 끝까지 탐색
        for (int idx = 0; idx < arr.size(); idx++) {
            // 배열의 크기가 비어있지않고, 크기만큼 채움.

            if (!result.isEmpty() && result.getFirst().index <= idx - l) {
                result.pollFirst();
            }
            // 지금 숫자가 안에 있는 숫자보다 작을때까지 싹다 밀어버림.
            while (!result.isEmpty() && arr.get(idx) < result.getLast().value) {
                result.pollLast(); // pop() 또 마지막 값 뽑는건데 왜 다르게 나오는지 모르겠음, 재영갓
            }
            // 더해줌
            result.add(new Node(idx, arr.get(idx)));
            // 빌더
            sb.append(result.peekFirst().value).append(" ");
        }
        //출력
        System.out.println(sb);
    }
}
//12 3
//1 5 2 3 6 2 3 7 3 5 2 6