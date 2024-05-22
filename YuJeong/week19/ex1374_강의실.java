import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Lecture implements Comparable<Lecture>{
    char state;
    int time;
    Lecture(char state, int time){
        this.state = state;
        this.time = time;
    }
    @Override
    public int compareTo(Lecture o){
        // 시간 기준 오름차순 정렬
        // 시간이 같을 경우 state가 End가 Start보다 우선 정렬(알파벳 오름차순)
        if(this.time == o.time) return this.state - o.state;
        else return this.time - o.time;
    }
}

public class ex1374_강의실 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture('S', start));
            lectures.add(new Lecture('E', end));
        }
        // compareTo에서 정의한대로 정렬
        Collections.sort(lectures);
//        // 확인
//        for(Lecture lecture : lectures) {
//            System.out.println("lecture.state = " + lecture.state + ", lecture.time = " + lecture.time);
//        }
        System.out.println(greedy(lectures));
    }
    static int greedy(List<Lecture> lectures){
        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        for(Lecture now : lectures) {
            if(now.state == 'S'){
                cnt++;
                answer = Math.max(answer, cnt);
            }
            else {
                cnt--;
                answer = Math.max(answer, cnt);
            }
        }
        return answer;
    }
}
