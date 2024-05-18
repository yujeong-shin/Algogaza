import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1043_거짓말 {
    static class People{
        int num;
        boolean isTruth;
        public People(int num){
            this.num = num;
            this.isTruth = false;
        }
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
        for(int i=0; i<truthPeopleCount; i++){
            PeopleList.get(Integer.parseInt(st.nextToken())-1).knowTruth();
        }
        for(int i=0; i<M; i++){
            roomList.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int peopleCount = Integer.parseInt(st.nextToken());
            for(int j=0; j<peopleCount; j++){
                roomList.get(i).add(PeopleList.get(Integer.parseInt(st.nextToken())-1));
            }
        }
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
        for(List<People> peopleList : roomList){
            if(checkRoom(peopleList)) result++;
        }
        System.out.println(result);
    }
    public static void changeTruth(List<People> peopleList){
        for(People people : peopleList){
            people.knowTruth();
        }
    }
    public static boolean checkRoom(List<People> peopleList){
        for(People people: peopleList){
            if(people.isTruth) return false;
        }
        return true;
    }
}
