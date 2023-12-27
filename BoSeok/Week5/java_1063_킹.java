package BoSeok.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class java_1063_킹 {
    static int[] move(String s) {
        int x = 0;
        int y = 0;
        if (s.equals("R")) {
            x = 1;
        } else if (s.equals("L")) {
            x = -1;
        } else if (s.equals("B")) {
            y = -1;
        } else if (s.equals("T")) {
            y = 1;
        } else if (s.equals("RT")) {
            x = 1;
            y = 1;
        } else if (s.equals("LT")) {
            x = -1;
            y = 1;
        } else if (s.equals("RB")) {
            x = 1;
            y = -1;
        } else if (s.equals("LB")) {
            x = -1;
            y = -1;
        }
        return new int[]{x, y};
    }

    static int[] king, stone;
    static int n,nx,ny;
    static Map<String, Integer> map = Map.of(
            "A", 1,
            "B", 2,
            "C", 3,
            "D", 4,
            "E", 5,
            "F", 6,
            "G", 7,
            "H", 8
    );

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[2]);
//        king ,stone 해쉬로 값 가져오기
        int[] king = new int[]{ map.get(String.valueOf(s[0].charAt(0))), s[0].charAt(1) - '0'}; // [1,1]
        int[] stone = new int[]{map.get(String.valueOf(s[1].charAt(0))), s[1].charAt(1) - '0'}; // [1,2]

        for (int i = 0; i < n; i++) {

            int[] mo = move(bf.readLine());
            int nx = king[0] + mo[0];
            int ny = king[1] + mo[1];
            if (0 < nx && nx <= 8 && 0 < ny && ny <= 8) {
                if (nx == stone[0] && ny == stone[1]) {
                    int sx = stone[0] + mo[0];
                    int sy = stone[1] + mo[1];
                    if (0 < sx && sx <= 8 && 0 < sy && sy <= 8) {
                        king = new int[]{nx, ny};
                        stone = new int[]{sx, sy};
                    }
                }
                else {
                    king = new int[]{nx, ny};
                }
            }
        }
        System.out.println((char)(64+king[0])+""+(king[1]));
        System.out.println((char)(64+stone[0])+""+(stone[1]));
    }
}
