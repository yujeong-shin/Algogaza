import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1374_강의실 {
    // 강의 정보를 담아줄 클래스 생성
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
    // 시작 시간 기준 오름차순, 시작 시간이 같을 경우엔 끝나는 시간이 빠른 순으로 오름차순 시키는 정렬 구현체
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
        // 강의 리스트를 위에 정의한 구현체를 사용하여 정렬
        classList.sort(new ClassComparator());
        // 끝나는 시간을 담아줄 PQ 생성
        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();
        endTimeQueue.offer(classList.get(0).endTime);
        for(int i=1; i<N; i++){
        // PQ의 값을 확인(다음 강의가 끝나는 시간)한 후 다음 강의의 시작 시간보다 작다면 강의가 이미 끝나고 같은 강의실 사용 가능한 것을 의미
        // 끝나는 시간이 다음 강의의 시작 시간보다 작다? => 같은 강의실을 사용해도 된다.
        // 끝나는 시간이 다음 강의의 시작 시간보다 크다? => 현재 강의실은 사용중이니 새로운 강의실을 사용해야한다.
        // 여기서 강의실의 갯수는 PQ의 사이즈를 의미
        if(endTimeQueue.peek() <= classList.get(i).startTime){
            endTimeQueue.poll();
        }
        // 강의를 체크할 때마다 pq에 추가
        endTimeQueue.offer(classList.get(i).endTime);
    }
        System.out.println(endTimeQueue.size());
    }
}
