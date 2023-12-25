import java.io.*;
import java.nio.Buffer;
import java.util.*;

import static java.util.Collections.checkedQueue;
import static java.util.Collections.swap;

public class Q5430 {
    static boolean isSwap;
    static Deque<String> deque;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            char[] command = st.nextToken().toCharArray();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            String arrStr = st.nextToken();
            parsingToArray(arrStr);
            if(execute(command, n)){
                sb.append(parsingToString());
            } else sb.append("error");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    private static boolean execute(char[] command, int n){
        isSwap = false;
        for(int i=0; i<command.length; i++){
            // R이 나올 때마다 flag의 값을 반전시켜 pollFirst or pollLast
            if(command[i] == 'R'){
                isSwap = !isSwap;
            }
            else if(command[i] == 'D'){
                if(n == 0) return false;
                if(deque.isEmpty()){
                    return false;
                }
                if(isSwap) deque.pollLast();
                else deque.pollFirst();
            }
        }
        return true;
    }
    private static void parsingToArray(String str){
        str = str.replace("[","");
        str = str.replace("]","");
        String[] strArr = str.split(",");
        deque =  new LinkedList<>(Arrays.asList(strArr));
    }
    private static String parsingToString(){
        StringBuilder result = new StringBuilder();
        result.append("[");
        while(!deque.isEmpty()){
            if(isSwap) result.append(deque.pollLast());
            else result.append(deque.pollFirst());

            if(!deque.isEmpty()) result.append(",");
        }
        result.append("]");
        return result.toString();
    }
}
