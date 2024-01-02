import java.io.*;
import java.util.*;

public class Q_1063 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String stone = st.nextToken();
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("T", new ArrayList<>(Arrays.asList(0, 1)));
        map.put("B", new ArrayList<>(Arrays.asList(0, -1)));
        map.put("L", new ArrayList<>(Arrays.asList(-1, 0)));
        map.put("R", new ArrayList<>(Arrays.asList(1, 0)));
        map.put("RT", new ArrayList<>(Arrays.asList(1, 1)));
        map.put("LT", new ArrayList<>(Arrays.asList(-1, 1)));
        map.put("RB", new ArrayList<>(Arrays.asList(1, -1)));
        map.put("LB", new ArrayList<>(Arrays.asList(-1, -1)));

        int kingX = king.substring(0, 1).charAt(0) - 'A' + 1;
        int kingY = Integer.parseInt(king.substring(1, 2));

        int stoneX = stone.substring(0, 1).charAt(0) - 'A' + 1;
        int stoneY = Integer.parseInt(stone.substring(1, 2));

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            int movementX = map.get(cmd).get(0);
            int movementY = map.get(cmd).get(1);
            //check if the stone is at the position of
            //where the king should move to
            //if so, move the stone too!
            if ((movementX + kingX == stoneX) && (movementY + kingY == stoneY)) {
                //check the stone's movement if it's still in the valid position of the board
                if (((movementX + stoneX <= 8) && (movementY + stoneY <= 8)
                        && (movementX + stoneX >= 1) && (movementY + stoneY >= 1))) {
                    //move the king
                    kingX = stoneX;
                    kingY = stoneY;
                    //then move the stone
                    stoneX = stoneX + movementX;
                    stoneY = stoneY + movementY;
                }
            }
            //if not (stone not in the way), move the king
            //check the king's movement if it's still in the valid position of the board
            else if (((movementX + kingX <= 8) && (movementY + kingY <= 8)
                    && (movementX + kingX >= 1) && (movementY + kingY >= 1))
            ) {
                //if valid
                kingX = kingX + movementX;
                kingY = kingY + movementY;
            }

        }
        bw.write(((char) (kingX + 'A' - 1)) + ((kingY) + "\n"));
        bw.write(((char) (stoneX + 'A' - 1)) + ((stoneY) + "\n"));
        bw.flush();
        bw.close();
    }
}
