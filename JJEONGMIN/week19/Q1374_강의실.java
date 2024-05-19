import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1374_강의실 {
    static class Class{
        int classNum;
        int startTime;
        int endTime;
        public Class(int classNum, int startTime, int endTime){
            this.classNum = classNum;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    public static class ClassComparator implements Comparator<Class> {
        @Override
        public int compare(Class o1, Class o2) {
            if(o1.startTime == o2.startTime) return o1.endTime - o2.endTime;
            return o1.startTime - o2.startTime;
        }
    }
    static List<Class> classList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int classNum = Integer.parseInt(st.nextToken());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            classList.add(new Class(classNum, startTime, endTime));
        }
        classList.sort(new ClassComparator());
        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();
        endTimeQueue.offer(classList.get(0).endTime);
        for(int i=1; i<N; i++){
        if(endTimeQueue.peek() <= classList.get(i).startTime){
            endTimeQueue.poll();
        }
        endTimeQueue.offer(classList.get(i).endTime);
    }
        System.out.println(endTimeQueue.size());
    }
}
