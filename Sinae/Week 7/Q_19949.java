import java.util.*;

public class Q_19949 {
    static List<Integer> given;
    static int sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

//        정답 집어넣기!
        given = new ArrayList<>();
        for (int i = 0; i < 10; i++) given.add(Integer.parseInt(st.nextToken()));

//      영재가 찍은 답 집어넣을 리스트!
        List<Integer> sub = new ArrayList<>();
        dfs(sub, 0, 0);
        System.out.println(sum);
    }

    static void dfs(List<Integer> sub, int count, int five) {
        if (sub.size() >= 3 && ((sub.get(count - 3) == sub.get(count - 2)) &&
                (sub.get(count - 2) == sub.get(count - 1)))) { //3개 연속 똑같은 값이 나올 경우 멈춰!
            return;
        }
        if (sub.size() == 10) { //3번 연속으로 같은 숫자가 없이 순열이 만들어졌을 경우, 답이랑 비교하기!
            for (int s = 0; s < sub.size(); s++) {
                if (sub.get(s) == given.get(s)) {
                    five++;
                }
            }
            if (five >= 5) { //5점 이상일 경우
                sum++;
            }
        } else {
            for (int j = 1; j <= 5; j++) {
                sub.add(j);
                count++; //count의 역할은 어디까지 순열이 만들어진 마지막 부분을 가리키는 pointer!
                dfs(sub, count, 0);
                count--;
                sub.remove(sub.size() - 1);
            }
        }
    }
}
