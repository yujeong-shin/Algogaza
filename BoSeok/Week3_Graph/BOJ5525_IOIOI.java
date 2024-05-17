package BoSeok.Week3_Graph;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ5525_IOIOI {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String temp = String.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder("I");
        String N = "OI";

        for (int i = 0; i < n; i++) {
            sb.append(N);
        }
        String pn = sb.toString();
        int count = 0;

        String ioi = sb.toString();
        int pos = temp.indexOf(ioi);
        while (true) {
            if (pos == -1) {
                break;
            }else {
                count++;
            }
            pos = temp.indexOf(ioi, pos+2);
        }
        System.out.println(count);
    }
}
