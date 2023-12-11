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
    static int n, m, person1, person2;
    static List<List<Person>> map;
    static int countOfMatch, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine()); //전체 사람 수
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
            map.get(child).add(new Person(parent, 0));
        }
        System.out.println(BFS(person1, person2));
    }
    public static int BFS(int start, int end){
        Queue<Person> Q = new LinkedList<>();
        boolean[] visit = new boolean[n+1];
        Q.add(new Person(start, 0));
        visit[start]=true;
        while(!Q.isEmpty()){
            Person nowPerson = Q.poll();
            if(nowPerson.number==end) return nowPerson.degreeOfKinship;
            for(Person nxtPerson : map.get(nowPerson.number)){
                if(!visit[nxtPerson.number]) {
                    visit[nxtPerson.number]=true;
                    //촌수 계산
                    nxtPerson.degreeOfKinship = nowPerson.degreeOfKinship+1;
                    Q.add(nxtPerson);
                }
            }
        }
        return -1;
    }
}
