package BoSeok.Week4;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class java_4673_셀프넘버 {
    public static void main(String[] args) {

//        1부터 10001 까지 생성자 만들어 넣기.

        // 1부터 10001 까지
        Set result = IntStream.rangeClosed(1, 10001)
//                각 숫자에 대해 메서드 호출
                .mapToObj(java_4673_셀프넘버::calculate)
//                데이터 싸악 모아서 set으로 만들어 줌
                .collect(Collectors.toSet()); // .collect(toSet) 가능


//        1부터 10001 까지
        List<Integer> answer = IntStream.rangeClosed(1, 10001)
//                위에 result에 없는값을 찾아서
                .filter(x -> !result.contains(x))
//                Integer 형이니깐 기본형인 int로 바꿔줌
                .boxed()
//                스근하게 다 모은다음에 리스트로 반환해줌.
                .collect(Collectors.toList());

        answer.forEach(System.out :: println);
    }

//    생성자 구하기.
    static int calculate(int n) {
        n = n + sumDigits(n);
        return n;
    }
//    각 자릿수 값 더하기
    static int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
