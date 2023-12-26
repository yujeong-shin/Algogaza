import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q5534 {
    static class Node{
        int first_index;
        int second_index;
        int diff;
        Node(int a, int b){
            this.first_index = a;
            this.second_index = b;
            this.diff = second_index - first_index;
        }
    }
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String name = st.nextToken();
        String[] strArr = new String[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            strArr[i] = st.nextToken();
        }
        for (String s : strArr) {
            if (makeSignboard(s, name.toCharArray())) answer++;
        }
        System.out.println(answer);
    }
    private static boolean makeSignboard(String str, char[] chArr) {
        List<Node> list = getIndex(str, chArr);
        for(int i=0; i<list.size(); i++){
            int count = 2;
            for(int j=list.get(i).second_index + list.get(i).diff; j<str.length(); j += list.get(i).diff){
                if(chArr[count] == str.charAt(j)){
                    count++;
                    if(count == chArr.length){
                        return true;
                    }
                } else break;
            }
        }
        return false;
    }
    private static List<Node> getIndex(String str, char[] chArr){
        List<Node> node = new LinkedList<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == chArr[0]) {
                for(int j=i; j<str.length(); j++){
                    if(str.charAt(j) == chArr[1]){
                        if(j+((j-i)*(chArr.length-2)) < str.length()) node.add(new Node(i,j));
                    }
                }
            }
        }
        return node;
    }
}
