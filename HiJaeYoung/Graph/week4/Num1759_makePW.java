package HiJaeYoung.Graph.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1759_makePW {
    static int L,C;
    static String[] chars;
    static boolean[] vist;
    static int vowel,other;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        chars = new String[C];
        vist = new boolean[C];
        vowel =0;
        other =0;
        sb = new StringBuilder();
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<C;i++){
            chars[i] = st.nextToken();
        }
        Arrays.sort(chars);
        List<String> tmp = new ArrayList<>();
        DFS(tmp,0,0);
        System.out.print(sb);
    }
    public static void DFS(List<String> tmp,int depth,int start){
        if(depth==L){
            if(vowel>=1 && other>=2){
                for(String now : tmp){
                    sb.append(now);
                }
                sb.append("\n");
                return;
            }
        }
        for(int i=start;i<C;i++){
            if(!vist[i]){
                vist[i] =true;
                if(chars[i].equals("a") ||chars[i].equals("e") || chars[i].equals("i")||chars[i].equals("o") ||chars[i].equals("u")){
                    vowel++;
                    tmp.add(chars[i]);
                    DFS(tmp,depth+1,i+1);
                    tmp.remove(tmp.size()-1);
                    vowel--;
                }else{
                    other++;
                    tmp.add(chars[i]);
                    DFS(tmp,depth+1,i+1);
                    tmp.remove(tmp.size()-1);
                    other--;
                }
                vist[i] = false;
            }
        }
    }
}
