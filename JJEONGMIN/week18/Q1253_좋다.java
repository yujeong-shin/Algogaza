import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q1253_좋다 {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int count = 0;
        for(int i=0; i<list.size(); i++){
            if(binarySearch(0, list.size()-1,list.get(i), i)) count++;
        }
        System.out.println(count);asdf
    }
    public static boolean binarySearch(int start, int end, int key, int index){
        while(start < end) {
            if(start == index) {
                start++;
                continue;
            }
            if(end == index) {
                end--;
                continue;
            }
            int sum = list.get(start) + list.get(end);
            if(sum == key) return true;
            else if(sum > key) end--;
            else if(sum < key) start++;
        }
        return false;
    }
}
