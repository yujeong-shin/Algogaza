package HiJaeYoung.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Num6987_월드컵 {
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        result = new int[3];
        for(int i=0;i<4;i++){
            st = new StringTokenizer(br.readLine());
            int math = 0;
            int count = 0;
            for(int j=0;j<18;j++){
                int nowNumber = Integer.parseInt(st.nextToken());
                count++;
                result[j%3] = nowNumber;
                math += nowNumber;
                if(count==3){
                    if(math != 5){

                    }
                    count= 0;
                    math= 0;
                }

            }
        }


    }
}
