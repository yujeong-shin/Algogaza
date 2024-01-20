import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex1759_암호만들기 {
    static int n, m, answer;
    static char[] ch, combi;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //n개 알파벳의 암호
        m = Integer.parseInt(st.nextToken()); //알파벳 총 개수
        combi = new char[n];
        visited = new boolean[m];
        ch = new char[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            ch[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(ch);

        DFS(0, 0);
        System.out.println(sb);
    }
    static void DFS(int L, int start){
        if(L==n){
            int vowelCnt=0, consonantCnt=0; //모음, 자음 cnt
            //m개 중 n개 뽑았을 때, 모음(a, e, i, o, u) 최소 한개, 자음 최소 두 개
            for(char c : combi){
                if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') vowelCnt++;
                else consonantCnt++;
            }
            if(vowelCnt>=1 && consonantCnt>=2) {
                for(char c : combi){
                    sb.append(c);
                }
                sb.append("\n");
            }
        }
        else{
            for (int i = start; i < m; i++) {
                if(!visited[i]){
                    visited[i] = true;
                    combi[L] = ch[i];
                    DFS(L+1, i+1);
                    visited[i] = false;
                }
            }
        }
    }
}
