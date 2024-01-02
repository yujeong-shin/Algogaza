// 킹

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1063 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] map = new int[8][8];

        String king = st.nextToken();
        int a = king.charAt(0) - 'A'; // 'A' : 65
        int b = 8 - (king.charAt(1) - '0'); // '0' : 48
        map[b][a] = 1; // king은 1

        String stone = st.nextToken();
        int c = stone.charAt(0) - 'A';
        int d = 8 - (stone.charAt(1) - '0');
        map[d][c] = 2; // stone은 2

        int king_x = -1; // 행
        int king_y = -1; // 열
        int stone_x = -1;
        int stone_y = -1;

        int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
        int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

        int king_ex = -1;
        int king_ey = -1;
        int stone_ex = -1;
        int stone_ey = -1;


        int n = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            switch (str) {
                case "R" : king_x = b + dx[0]; king_y = a + dy[0]; stone_x = d + dx[0]; stone_y = c + dy[0];
                    break;
                case "L" : king_x = b + dx[1]; king_y = a + dy[1]; stone_x = d + dx[1]; stone_y = c + dy[1];
                    break;
                case "B" : king_x = b + dx[2]; king_y = a + dy[2]; stone_x = d + dx[2]; stone_y = c + dy[2];
                    break;
                case "T" : king_x = b + dx[3]; king_y = a + dy[3]; stone_x = d + dx[3]; stone_y = c + dy[3];
                    break;
                case "RT" : king_x = b + dx[4]; king_y = a + dy[4]; stone_x = d + dx[4]; stone_y = c + dy[4];
                    break;
                case "LT" : king_x = b + dx[5]; king_y = a + dy[5]; stone_x = d + dx[5]; stone_y = c + dy[5];
                    break;
                case "RB" : king_x = b + dx[6]; king_y = a + dy[6]; stone_x = d + dx[6]; stone_y = c + dy[6];
                    break;
                case "LB" : king_x = b + dx[7]; king_y = a + dy[7]; stone_x = d + dx[7]; stone_y = c + dy[7];
                    break;
            }

            if(king_x >= 0 && king_x < 8 && king_y >= 0 && king_y < 8 && map[king_x][king_y] == 2) {
                if(stone_x >= 0 && stone_x < 8 && stone_y >= 0 && stone_y < 8) {
                    map[d][c] = 0;
                    map[stone_x][stone_y] = 2;
                    d = stone_x;
                    c = stone_y;
                    map[b][a] = 0;
                    b = king_x;
                    a = king_y;
                    map[king_x][king_y] = 1;
                }

            }else if(king_x >= 0 && king_x < 8 && king_y >= 0 && king_y < 8 && map[king_x][king_y] != 2) {
                map[b][a] = 0;
                b = king_x;
                a = king_y;
                map[king_x][king_y] = 1;
            }
        }
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(map[i][j]==1) {
                    king_ex = i;
                    king_ey = j;
                }
                if(map[i][j]==2) {
                    stone_ex = i;
                    stone_ey = j;
                }
            }
        }
        System.out.println((char)('A' + king_ey) + "" + (8 - king_ex));
        System.out.println((char)('A' + stone_ey)+ "" + (8 - stone_ex));

    }
}