package HiJaeYoung.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num15961_회전초밥 {
    static int N;
    static int[] beltOnSushi;
    static  int [] eatableSushi;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] beltOnSushi = new int[N];
        int[] eatableSushi = new int[N];
        for(int i=0;i<N;i++){
            beltOnSushi[i] = Integer.parseInt(bf.readLine());
        }
        int start = 0;
        int end = k-1;

        for(int i=0;i<N;i++){


        }
        System.out.println(answer);
    }

    public static int convertIndex(int index){
        if(index>=N){
            return index-N;
        }
        return index;
    }
}
