import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Person{
    int number, degreeOfKinship;
    Person(int number, int degreeOfKinship){
        this.number = number;
        this.degreeOfKinship = degreeOfKinship;
    }
}
public class ex2644 {
    static int m, person1, person2;
    static List<List<Person>> map;
    static int countOfMatch, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine()); //전체 사람 수
        map = new ArrayList<>();
        for (int i = 0; i <= n; i++) { //전체 사람 수만큼 ArrayList 공간 할당
            map.add(new ArrayList<>());
        }
        st = new StringTokenizer(bf.readLine());
        person1 = Integer.parseInt(st.nextToken()); //촌수를 구해야 할 사람 2명
        person2 = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(bf.readLine()); //부모-자식 관계 개수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int parent = Integer.parseInt(st.nextToken()); //부모
            int child = Integer.parseInt(st.nextToken()); //자식
            map.get(parent).add(new Person(child, 0)); //촌수 값 0 기본 세팅
        }
        System.out.println(BFS(1));
    }
    public static int BFS(int root){
        Queue<Person> Q = new LinkedList<>();
        Q.add(new Person(root, 0));
        while(!Q.isEmpty()){
            Person parent = Q.poll();
            for(Person child : map.get(parent.number)) {
                //자식의 depth = 부모 depth+1
                child.degreeOfKinship = parent.degreeOfKinship+1;
                //자식이 촌수를 구해야 할 사람에 포함되면 체크
                if(child.number==person1 || child.number==person2) {
                    countOfMatch++;
                    answer += child.degreeOfKinship;
                }
                Q.add(child);
            }
        }
        if(countOfMatch==2) return answer;
        else return -1;
    }
}
