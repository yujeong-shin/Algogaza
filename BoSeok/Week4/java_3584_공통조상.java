package BoSeok.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class java_3584_공통조상 {
    static int t;
    static int n;
    static StringTokenizer stk;
    static int[] parents;
    static boolean[] visited;
    static ArrayList<Integer> parentsList;  // 왼쪽 부모들

//    static ArrayList<Integer> lefts;  // 왼쪽 부모들
//    static ArrayList<Integer> rights; // 오른쪽 부모들

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(bf.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(bf.readLine());


            // 부모 초기값은 자기자신이 부모이다.
//            List<Integer> parents = IntStream.rangeClosed(0, n)
//                    .boxed()
//                    .collect(Collectors.toList());
            parents = new int[n + 1];
            visited = new boolean[n + 1];
            for (int j = 0; j < n - 1; j++) {
                stk = new StringTokenizer(bf.readLine());

//                a 가 b의 부모이다. graph[b-1] = a
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                parents[b] = a; // a의 부모는 b
            }
            stk = new StringTokenizer(bf.readLine());
            int left = Integer.parseInt(stk.nextToken());
            int right = Integer.parseInt(stk.nextToken());

            calculate(left, right);

/*//            Optional<Integer> : null을 다루는 방법, 값이 존재할수도 안 할 수도 있음
            Integer res = IntStream.range(0, rights.size())
                    .filter(idx -> lefts.get(idx) == rights.get(idx)) // 인덱스가 같을때 밸류도 같은 값을 찾아주고.
                    .mapToObj(lefts::get) // 찾았을때 해당 인덱스의 값을 가져오고
                    .findFirst().orElse(0);
            System.out.println(res);*/
        }
    }

    private static void calculate(int left, int right) {
        while (left > 0) {
            visited[left] = true;
            left = parents[left];
        }
        while (right > 0) {
            if (visited[right]) {
                System.out.println(right);
                break;
            }
            right = parents[right];
        }
    }
}

    /*
    private static ArrayList<Integer> find_parent(List<Integer> parents, int node) {
        parentsList = new ArrayList<>();
        parentsList.add(node);
//        부모가 없음, 자기자신이 부모일떄까지 찾아준다.
        while (parents.get(node) != node) {
//           부모의 부모를 더해주고.
            parentsList.add(parents.get(node));
//            부모를 부모의 부모로 바꿔줌 -> 부모의 부모를 또 찾아야 하므로.
            node = parents.get(node);
        }
        return parentsList;
    }
}
/*
    Optional res = IntStream.range(0, rights.size())

            .filter(idx -> lefts.get(idx) == rights.get(idx)) // 인덱스가 같을때 밸류도 같은 값을 찾아주고.
            .mapToObj(lefts::get) // 찾았을때 해당 인덱스의 값을 가져오고
            .findFirst()

            System.out.println(res);
            --> Optional[4]

설명 : findFirst() 반환값이 Optional이다. null이 들어갔을때 nullpoint에러가 안나오고 Optional[null] 이 들어간다.
아래 코드로 하면 백준에서는 출력 4, 3 을 원하지만 Optional[4] Optional[3] 으로 출력된다.
벗겨내고 싶으면 값이 없을 겨우인 기본값을 지정해줘야한다 (orElse(0)) -> 값이 없으면 0으로 반환 -> Integer형


            */

