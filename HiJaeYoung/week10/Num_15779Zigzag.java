package HiJaeYoung.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num_15779Zigzag {
    // N = 3 always 2 ? -> 1 5 2 = 3 , 1 1 1 = 1
    //
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            nums[i] = Long.parseLong(st.nextToken());
        }
        int maxLen = 1;
        for(int i=0; i<n-3;i++){
            boolean isBig1 = false;
            boolean isBig2 = false;
            maxLen++;
            if(nums[i]<=nums[i+1]) {
                isBig1 = true;
            }
            if(nums[i+1]<nums[i+2]){
                isBig2 = true;
            }
            if(isBig1 == isBig2){
                maxLen = 1;
                continue;
            }
            maxLen++;
        }
        System.out.println(maxLen);
    }
}
