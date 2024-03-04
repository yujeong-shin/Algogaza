import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18111_마인크래프트 {
    static Map<Integer, Integer> hashMap = new HashMap<>();
    static Set<Integer> hashSet = new HashSet<>();
    static int minute = Integer.MAX_VALUE, height = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int num = Integer.parseInt(st.nextToken());
                hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
                hashSet.add(num);
            }
        }
        List<Integer> list = new ArrayList<>(hashSet);
        Collections.sort(list);

        for(int i=list.get(0); i <= list.get(list.size()-1); i++){
            mineCraft(B, i, list);
        }
        System.out.println(minute + " " + height);
    }
    private static void mineCraft(int count, int target, List<Integer> list) {
        int currentMinute = 0;

        for (Integer blockHeight : list) {
            int blockCount = hashMap.get(blockHeight);
            if (blockHeight > target) {
                currentMinute += (blockHeight - target) * blockCount * 2;
                count += (blockHeight - target) * blockCount;
            } else if (blockHeight < target) {
                currentMinute += (target - blockHeight) * blockCount;
                count -= (target - blockHeight) * blockCount;
            }
        }
        if(count >= 0 && currentMinute < minute){
            minute = currentMinute;
            height = target;
        }
        if(count >= 0 && minute == currentMinute && target > height){
            height = target;
        }
    }
}
