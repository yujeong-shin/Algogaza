import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ex5430_AC {
    static int n;
    static boolean direction;
    static Deque<String> deque;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            char[] functions = st.nextToken().toCharArray();

            n = Integer.parseInt(br.readLine());

            String str = br.readLine();
            // String [1,2,3,4] --> Deque 1, 2, 3, 4
            makeIntArray(str);

            if(calculate(functions)){
                sb.append(makeAnswer());
            } else sb.append("error");
            sb.append("\n");
        }
        System.out.println(sb);
//        bw.write(sb.toString());
//        bw.flush();
    }

    static void makeIntArray(String str){
        str = str.replace("[","").replace("]","");
        String[] charArr = str.split(",");
        deque =  new LinkedList<>(Arrays.asList(charArr));
    }

    static boolean calculate(char[] functions){
        // true : 순방향, false : 역방향
        direction = true;
        for(char funcion : functions){
            if(funcion == 'R'){
                direction = !direction;
            }
            else if(funcion == 'D'){
                if(n == 0) return false;
                if(deque.isEmpty()){
                    return false;
                }
                if(direction) deque.pollFirst();
                else deque.pollLast();
            }
        }
        return true;
    }

    static String makeAnswer(){
        // Deque 1, 2, 3, 4 --> String [1,2,3,4]
        StringBuilder result = new StringBuilder();
        result.append("[");
        while(!deque.isEmpty()){
            if(direction) result.append(deque.pollFirst());
            else result.append(deque.pollLast());

            if(!deque.isEmpty()) result.append(",");
        }
        result.append("]");
        return result.toString();
    }
}