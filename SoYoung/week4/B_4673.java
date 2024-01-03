// 셀프 넘버

import java.util.*;

public class B_4673 {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        for(int i=1; i<=10000; i++) {
            int num = 0;
            int temp = 0;
            num += i;
            temp = i;
            num += temp % 10;
            temp -= temp % 10;
            while(temp / 10 != 0) {
                if(temp == 0) break;
                temp /= 10;
                num += temp % 10;;
                temp -= temp % 10;
            }
            if(num <= 10000 && !numList.contains(num)) {
                numList.add(num);
            }
        }
        numList.sort(Comparator.naturalOrder());
        for(int i=1; i<=10000; i++) {
            if(!numList.contains(i)) {
                System.out.println(i);
            }
        }
    }

}