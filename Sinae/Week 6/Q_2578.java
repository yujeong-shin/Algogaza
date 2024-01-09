import java.io.*;
import java.util.*;

class Q_2578 {
    static int[][] matrix = new int[5][5];
    static List<Integer> calledOut;
    static List<Integer> verChk = new ArrayList<>();
    static List<Integer> horChk = new ArrayList<>();
    static Map<Integer, Integer> horMap = new HashMap<>();
    static Map<Integer, Integer> verMap = new HashMap<>();
    static int left = 0, right = 0, bingo = 0, count = 0;
    static boolean l = false, r = false, check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        calledOut = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int a = 0; a < 5; a++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int b = 0; b < 5; b++) {
                calledOut.add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i : calledOut) {
            chk(i);
            count++;
            if (check) break;
        }
        System.out.println(count);
    }

    static void chk(int called) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (called == matrix[i][j]) {
                    horMap.put(i, horMap.getOrDefault(i, 0) + 1);
                    verMap.put(j, verMap.getOrDefault(j, 0) + 1);
                    if (i == j) {
                        left++;
                        chkDiagonal();
                    }
                    if ((i == 0 && j == 4) || (i == 1 && j == 3) || (i == 2 && j == 2) || (i == 3 & j == 1) || (i == 4 && j == 0)) {
                        right++;
                        chkDiagonal();
                    }
                    chkVertical();
                    chkHorizontal();
                    if (bingo >= 3) {
                        check = true;
                        return;
                    }
                }
            }
        }
    }

    static void chkVertical() {
        for (Map.Entry<Integer, Integer> e : verMap.entrySet()) {
            if (e.getValue() == 5 && !verChk.contains(e.getKey())) {
                verChk.add(e.getKey());
                bingo++;
            }
        }
    }

    static void chkHorizontal() {
        for (Map.Entry<Integer, Integer> e : horMap.entrySet()) {
            if (e.getValue() == 5 && !horChk.contains(e.getKey())) {
                horChk.add(e.getKey());
                bingo++;
            }
        }
    }

    static void chkDiagonal() {
        if (left == 5 && !l) {
            bingo++;
            l = true;
        }
        if (right == 5 && !r) {
            bingo++;
            r = true;
        }
    }
}
