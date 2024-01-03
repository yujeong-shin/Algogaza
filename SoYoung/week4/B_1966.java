// 프린터 큐

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1966 {
    public static void main(String[] args) throws IOException {
        List<Integer> countList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] importance = new int[a];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < a; j++) {
                importance[j] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            Queue<int[]> queue = new LinkedList<>();
            for (int j = 0; j < a; j++) {
                queue.add(new int[]{j, importance[j]}); // 인덱스, 중요도
            }

            while (!queue.isEmpty()) {
                int[] front = queue.poll();
                boolean isPrinted = true;

                for (int j = 0; j < queue.size(); j++) {
                    int[] doc = queue.poll();
                    if (doc[1] > front[1]) {
                        isPrinted = false;
                    }
                    queue.add(doc);
                }

                if (isPrinted) {
                    count++;
                    if (front[0] == b) {
                        countList.add(count);
                        break;
                    }
                } else {
                    queue.add(front);
                }
            }
        }

        for (int a : countList) {
            System.out.println(a);
        }
    }
}