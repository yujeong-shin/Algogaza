import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Q10814_나이순_정렬 {
    static class People{
        int age;
        String name;
        People(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
    static class PeopleComparator implements Comparator<People>{
        @Override
        public int compare(People o1, People o2) {
            return o1.age - o2.age;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<People> list = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new People(Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        list.stream()
                .sorted(new PeopleComparator())
                .map(people -> people.age + " " + people.name)
                .forEach(System.out::println);
    }
}
