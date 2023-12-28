import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1063_킹 {
    static Map<String, int[]> movement = Map.of(
            "R", new int[]{0, 1},
            "L", new int[]{0,-1},
            "B", new int[]{-1,0},
            "T", new int[]{1,0},
            "RT", new int[]{1,1},
            "LT", new int[]{1,-1},
            "RB", new int[]{-1,1},
            "LB", new int[]{-1,-1}
    );
    static StringBuilder sb = new StringBuilder();
    static char[] kingLocation, stoneLocation;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        kingLocation = st.nextToken().toCharArray();
        stoneLocation = st.nextToken().toCharArray();
        int loop = Integer.parseInt(st.nextToken());
        String[] move = new String[loop];

        for(int i=0; i<loop; i++){
            st = new StringTokenizer(br.readLine());
            move[i] = st.nextToken();
        }

        for(int i=0; i<loop; i++){
            setMovement(move[i]);
        }

        sb.append(kingLocation).append("\n");
        sb.append(stoneLocation).append("\n");
        System.out.println(sb.toString());
    }
    private static void setMovement(String move){
        int[] command = movement.get(move);
        int nextH = kingLocation[1]+command[0];
        int nextW = kingLocation[0]+command[1];
        if(nextH < 49 || nextW < 65 || nextH > 56 || nextW > 72) return;
        else {
            char prevW = kingLocation[0];
            char prevH = kingLocation[1];
            kingLocation[0] = (char)nextW;
            kingLocation[1] = (char)nextH;
            if(nextH == stoneLocation[1] && nextW == stoneLocation[0]){
                int stone_nextH = stoneLocation[1]+command[0];
                int stone_nextW = stoneLocation[0]+command[1];
                if(stone_nextH < 49 || stone_nextW < 65 || stone_nextH > 56 || stone_nextW > 72) {
                    kingLocation[0] = (char)prevW;
                    kingLocation[1] = (char)prevH;
                    return;
                }
                else {
                    stoneLocation[0] = (char)stone_nextW;
                    stoneLocation[1] = (char)stone_nextH;
                }
            }
        }
    }
}


