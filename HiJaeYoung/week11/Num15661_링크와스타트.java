package HiJaeYoung.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num15661_링크와스타트 {
    static int[][] map;
    static int answer;
    static Set<List> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        map = new int[n+1][n+1];
        answer = Integer.MAX_VALUE;
        set = new HashSet<>();
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=2;i<=n/2;i++){
            makeTeam(n,i,1,new boolean[n+1],new ArrayList<>());
        }
        System.out.println(answer);
    }
    public static void makeTeam(int n,int size,int start,boolean[] vist, List<Integer> tmp){
        if(size == tmp.size()){
            // 점수 계산
            List<Integer> tmp2 = new ArrayList<>();
            for(int i =1;i<=n;i++){
                if(!vist[i]){
                    tmp2.add(i);
                }
            }
            if(set.contains(tmp)){
                return;
            }
            set.add(tmp);
            set.add(tmp2);
            answer = Math.min(answer,score(n,tmp,tmp2));
        }
        for(int i=start; i<=n;i++){
            if(!vist[i]) {
                vist[i] = true;
                tmp.add(i);
                makeTeam(n, size, i+1,vist, tmp);
                tmp.remove(tmp.size() - 1);
                vist[i] = false;
            }
        }
    }
    public static int score(int n, List<Integer> tmp,List<Integer>tmp2){
        int link = 0;
        int start = 0;
        for(int a : tmp){
            for(int b : tmp){
                link += map[a][b];
            }
        }
        for(int a : tmp2){
            for(int b : tmp2){
                start += map[a][b];
            }
        }
        if(link-start>0){
            return link-start;
        }else{
            return (link-start)*-1;
        }
    }

}
