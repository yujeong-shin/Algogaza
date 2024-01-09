import java.io.*;
import java.util.*;

class Q_2477 {
    static List<int[]> coordinates = new ArrayList<>();
    static int num;
    static Map<Integer, Integer> typeMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int movement = Integer.parseInt(st.nextToken());
            coordinates.add(new int[]{direction, movement});
            typeMap.put(direction, typeMap.getOrDefault(direction, 0) + 1);
        }
//        System.out.println(typeMap); //기본 'ㄱ'자
        if (typeMap.get(1) == 2 && typeMap.get(4) == 2) {
            changeTypeTwo();

        } else if (typeMap.get(2) == 2 && typeMap.get(4) == 2) {
            changeTypeThree();
        } else if (typeMap.get(2) == 2 && typeMap.get(3) == 2) {
            changeTypeFour();
        }
        int m = 0;
        int n = 0;
        int ver = 0;
        int hor = 0;
        for (int i = 0; i < coordinates.size(); i++) {
            if (coordinates.get(i)[0] == 2) {
                hor = coordinates.get(i)[1];
            }
            if (coordinates.get(i)[0] == 4) {
                ver = coordinates.get(i)[1];
            } else if (coordinates.get(i)[0] == 1 && i != coordinates.size() - 1) {
                if (coordinates.get(i + 1)[0] == 3) {
                    m = coordinates.get(i)[1];
                    n = coordinates.get(i + 1)[1];
                }
            } else if (coordinates.get(i)[0] == 1 && i == coordinates.size() - 1) {
                if (coordinates.get(0)[0] == 3) {
                    m = coordinates.get(i)[1];
                    n = coordinates.get(0)[1];
                }
            }
        }
        System.out.println((ver * hor - (m * n)) * num);
    }

    static void changeTypeTwo() {
        for (int[] i : coordinates) {
            if (i[0] == 1) {
                i[0] = 3;
            } else if (i[0] == 2) {
                i[0] = 4;
            } else if (i[0] == 3) {
                i[0] = 2;
            } else if (i[0] == 4) {
                i[0] = 1;
            }
        }
    }

    static void changeTypeThree() {
        for (int[] i : coordinates) {
            if (i[0] == 1) {
                i[0] = 2;
            } else if (i[0] == 2) {
                i[0] = 1;
            } else if (i[0] == 3) {
                i[0] = 4;
            } else if (i[0] == 4) {
                i[0] = 3;
            }
        }
    }

    static void changeTypeFour() {
        for (int[] i : coordinates) {
            if (i[0] == 1) {
                i[0] = 4;
            } else if (i[0] == 2) {
                i[0] = 3;
            } else if (i[0] == 3) {
                i[0] = 1;
            } else if (i[0] == 4) {
                i[0] = 2;
            }
        }
    }
}