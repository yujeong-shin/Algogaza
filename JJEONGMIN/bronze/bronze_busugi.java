import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bronze_busugi {
    static String[] croa = {"c=", "c-", "dz=", "d-", "lj","nj","s=","z="};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Character, Integer> map = new HashMap<>();
        String str = st.nextToken();
        for(int i=0; i<str.length(); i++){
            for(int j=0; j<croa.length; j++){
                if(str.contains(croa[j])) str = str.replace(croa[j], "1");
            }
        }
        System.out.println(str.length());
    }
}
