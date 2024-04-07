import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Solution {
    public static void main(String[] args) {
        String[] dates = {"0101", "0110", "0120", "0205", "0214", "0228", "0305", "0310"};

        int count = countDatesWithin5Days(dates);
        System.out.println("날짜 차이가 5 미만인 수의 개수: " + count);
    }

    public static int countDatesWithin5Days(String[] dates) {
        int count = 0;

        // 년도를 현재 년도로 고정하여 "MMdd" 형식의 문자열을 파싱
//        int year = LocalDate.get().getYear();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMdd");
        LocalDate[] localDates = new LocalDate[dates.length];

        // 문자열 배열을 LocalDate 배열로 변환
        for (int i = 0; i < dates.length; i++) {
            String dateString = dates[i];
            localDates[i] = LocalDate.parse(dateString, formatter);
        }

        // 투 포인터 알고리즘을 사용하여 날짜 차이가 5 미만인 수를 찾음
        int left = 0, right = 0;
        while (right < localDates.length) {
            if (localDates[right].minusDays(5).isBefore(localDates[left])) {
                count += right - left; // 차이가 5 미만인 수의 개수 추가
                right++; // 오른쪽 포인터를 한 칸 오른쪽으로 이동
            } else {
                left++; // 왼쪽 포인터를 한 칸 오른쪽으로 이동
            }
        }

        return count;
    }
}