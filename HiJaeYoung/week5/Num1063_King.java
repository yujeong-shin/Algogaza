package HiJaeYoung.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Num1063_King {
    static int[] dx ={1,-1,0,0,1,-1,1,-1}, dy ={0,0,-1,1,1,1,-1,-1};
    static Map<String,Integer> commands ;
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        char[] king = st.nextToken().toCharArray();
        char[] stone = st.nextToken().toCharArray();
        commands = new HashMap<>();
        commands.put("R",1);
        commands.put("L",2);
        commands.put("B",3);
        commands.put("T",4);
        commands.put("RT",5);
        commands.put("LT",6);
        commands.put("RB",7);
        commands.put("LB",8);
        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            String command = bf.readLine();
            int index = commands.get(command)-1;
            System.out.println(command);
            if(king[0]+dx[index]<='Z' && king[0]+dx[index]>='A' && Character.getNumericValue(king[1])+dy[index]>=1&& Character.getNumericValue(king[1])+dy[index]<=9){
                king[0] +=dx[index];
                String tmp = String.valueOf(Character.getNumericValue(king[1])+dy[index]);
                king[1] = tmp.charAt(0);
            }
            if(Arrays.toString(king).equals(Arrays.toString(stone))){
                if(stone[0]+dx[index]<='Z' && stone[0]+dx[index]>='A' && Character.getNumericValue(stone[1])+dy[index]>=1
                        && Character.getNumericValue(stone[1])+dy[index]<=9){
                    stone[0] += dx[index];
                    stone[1] += dy[index];
                }
            }else{
                king[0] -=dx[index];
                king[1] -=dy[index];
            }

//            System.out.println(Arrays.toString(stone));
        }
        System.out.println(Arrays.toString(king));
        System.out.println(Arrays.toString(stone));
    }
}
