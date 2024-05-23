import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1043_거짓말 {
    // 각 사람 별 진실을 알고있는지 체크를 하기 위해 클래스를 선언해주었다.
    static class People{
        int num;
        boolean isTruth;
        public People(int num){
            this.num = num;
            this.isTruth = false;
        }
        // 진실을 알게된다면 true로 값 변경
        public void knowTruth(){
            this.isTruth = true;
        }
    }
    static List<People> PeopleList = new ArrayList<>();
    static List<List<People>> roomList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[M];
        for(int i=0; i<N; i++){
            PeopleList.add(new People(i));
        }
        st = new StringTokenizer(br.readLine());
        int truthPeopleCount = Integer.parseInt(st.nextToken());
        // [입력 단계] 진실을 이미 알고 있는 사람들은 Truth 값을 true 로 변경
        for(int i=0; i<truthPeopleCount; i++){
            PeopleList.get(Integer.parseInt(st.nextToken())-1).knowTruth();
        }

        // [입력 단계] 방 리스트 입력
        for(int i=0; i<M; i++){
            roomList.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int peopleCount = Integer.parseInt(st.nextToken());
            for(int j=0; j<peopleCount; j++){
                roomList.get(i).add(PeopleList.get(Integer.parseInt(st.nextToken())-1));
            }
        }

        // 모든 방을 반복적으로 돌면서 진실을 아는 사람이 있는 방일 경우 진실병이 퍼짐,,
        // Flag 를 두 개 두어 더 이상 진실이 퍼지지 않을 경우 반복문을 탈출할 수 있도록 조정
        // Todo: 이 단계에서 굉장한 시간적 비효율이 발생한다 추후 유니온 파인드 공부 후 적용해서 최적화 할 부분
        while (true) {
            boolean flag = false;
            for (int i=0; i<roomList.size(); i++) {
                boolean innerFlag = false;
                for (People people : roomList.get(i)) {
                    if (people.isTruth && !visited[i]) {
                        innerFlag = true;
                        flag = true;
                        visited[i] = true;
                        changeTruth(roomList.get(i));
                        break;
                    }
                }
                if (innerFlag) break;
            }
            if (!flag) break;
        }
        int result = 0;
        // 모든 방을 확인하여 진실을 모르는 사람이 있는 방만 체크 후 count
        for(List<People> peopleList : roomList){
            if(checkRoom(peopleList)) result++;
        }
        System.out.println(result);
    }
    // 해당 방에 진실을 알고 있는 사람이 있을 경우 해당 방에 있는 모든 사람은 진실을 알게 되는 메소드
    public static void changeTruth(List<People> peopleList){
        for(People people : peopleList){
            people.knowTruth();
        }
    }
    // 해당 방에 진실을 알고있는 사람이 있는지 체크하는 메소드
    public static boolean checkRoom(List<People> peopleList){
        for(People people: peopleList){
            if(people.isTruth) return false;
        }
        return true;
    }
}
