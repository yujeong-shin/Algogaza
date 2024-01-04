import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Q2477_참외밭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[6];
        int maxWidthIndex=0, maxHeightIndex=0;
        // K : 1m^2당 자라나는 참외 개수
        int K = Integer.parseInt(st.nextToken());
        int tempWidth = 0, tempHeight = 0;
        for(int i=0; i<6; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[i] = b;
            if(b > tempWidth) {
                if (a == 1 || a == 2) {
                    tempWidth = b;
                    maxWidthIndex = i;
                }
            }
            if(b > tempHeight){
                if(a == 3 || a == 4){
                    tempHeight = b;
                    maxHeightIndex = i;
                }
            }
        }
        int square1 = list[maxWidthIndex] * list[maxHeightIndex];
        List<Integer> linkedList = new LinkedList<>();
        linkedList = Arrays.stream(list).boxed().collect(Collectors.toList());
        for(int i=0; i<maxWidthIndex; i++){
            linkedList.add(linkedList.size(), linkedList.get(0));
            linkedList.remove(0);
        }
        int square2 = 0;
        if(linkedList.get(1) == list[maxHeightIndex]) square2 = linkedList.get(linkedList.size()-2) * linkedList.get(linkedList.size()-3);
        else square2 = linkedList.get(2) * linkedList.get(3);

        int answer = (square1-square2)*K;
        System.out.println(answer);
    }
}
