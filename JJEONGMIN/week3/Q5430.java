import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.swap;

public class Q5430 {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[101];
        int T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            char[] command = st.nextToken().toCharArray();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), "]");
            String arrStr = st.nextToken();
            if(n == 0) {
                System.out.println("error");
                continue;
            }
            execute(command, n, parsingToArray(arrStr));
        }
    }
    private static void execute(char[] command, int n, List<Integer> intArr){
        for(int i=0; i<command.length; i++){
            if(command[i] == 'R'){
                if(!flag){
                    intArr.sort(Comparator.reverseOrder());
                    flag = true;
                } else {
                    intArr.sort(Comparator.naturalOrder());
                    flag = false;
                }

            }
            else if(command[i] == 'D'){
                if(intArr.isEmpty()) {
                    System.out.println("error");
                    return;
                }
                intArr.remove(0);

            }
        }
        System.out.println(intArr);
    }
    private static List<Integer> parsingToArray(String str){
        str = str.replace("[","");
        str = str.replace("]","");
        String[] strArr = str.split(",");
        List<Integer> intArr = new ArrayList<>();
        for(int i=0; i<strArr.length; i++){
            intArr.add(Integer.parseInt(strArr[i]));
        }
        return intArr;
    }
    private static void parsingToString(){

    }
}
