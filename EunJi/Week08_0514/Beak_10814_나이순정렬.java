package EunJi.Week08_0514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Beak_10814_나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] age = new int[count];
        String[] name = new String[count];
        HashMap<Integer, Integer> map = new LinkedHashMap<>(); // key: index, value: age
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            age[i] = Integer.parseInt(st.nextToken());
            map.put(i, age[i]);
            name[i] = st.nextToken();
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return o1.getValue().compareTo(o2.getValue()); // 오름차순
                 return o1.getValue()-o2.getValue(); // 이 방법도 가능
//                 return o2.getValue().compareTo(o1.getValue()); // 내림차순
            }
        });

        for(Map.Entry<Integer, Integer> entry : list){
            System.out.println(entry.getValue() + " " + name[entry.getKey()]);
        }



    }
}
