import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11000_강의실_배정 {
    static class Class{
        int start;
        int end;
        public Class(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    static public class ClassComparator implements Comparator<Class> {
        @Override
        public int compare(Class o1, Class o2) {
            if(o1.start == o2.start) return o1.end - o2.end;
            return o1.start - o2.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Class> startClassList = new ArrayList<>();
        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();
        int N = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            startClassList.add(new Class(start, end));
            if(max < end) max = end;
        }
        startClassList.sort(new ClassComparator());
        endTimeQueue.offer(startClassList.get(0).end);
        for(int i=1; i<N; i++){
            if(endTimeQueue.peek() <= startClassList.get(i).start){
                endTimeQueue.poll();
            }
            endTimeQueue.offer(startClassList.get(i).end);
        }
        System.out.println(endTimeQueue.size());
    }
}

/**
 * 반례 모음
 * 3
 * 999999999 1000000000
 * 999999998 999999999
 * 1 999999998
 * 답: 1
 *
 * 8
 * 1 8
 * 9 16
 * 3 7
 * 8 10
 * 10 14
 * 5 6
 * 6 11
 * 11 12
 * 답: 3
 *
 * 3
 * 2 3
 * 3 5
 * 1 4
 * 답: 2
 *
 * 5
 * 1 2
 * 2 10
 * 5 6
 * 6 7
 * 7 8
 * 답: 2
 *
 * 3
 * 1 3
 * 1 2
 * 2 3
 * 답: 2
 *
 * 3
 * 5 6
 * 3 4
 * 1 2
 * 답: 1
 *
 * 4
 * 1 2
 * 1 4
 * 2 6
 * 4 5
 * 답: 2
 *
 * 7
 * 1 2
 * 1 4
 * 1 3
 * 2 5
 * 100 110
 * 5 7
 * 5 10
  */