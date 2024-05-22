package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<n+1; i++) {
            list.add(new int[2]);
        }

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            list.get(a)[0] = Integer.parseInt(st.nextToken());
            list.get(a)[1] = Integer.parseInt(st.nextToken());
        }

        list.sort(((o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        }));

        // 우선순위 큐를 사용하여 종료 시간을 관리
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list.get(1)[1]);

        for (int i = 2; i < n+1; i++) {
            // 현재 강의의 시작 시간이 가장 빨리 끝나는 강의의 종료 시간보다 늦거나 같으면 큐에서 제거
            if (list.get(i)[0] >= pq.peek()) {
                pq.poll();
            }
            // 현재 강의의 종료 시간을 큐에 추가
            pq.add(list.get(i)[1]);
        }

        // 필요한 최소 강의실의 수는 우선순위 큐에 남아있는 종료 시간의 수와 같음
        System.out.println(pq.size());
    }
}
