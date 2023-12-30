import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex1138_한줄로서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Character.getNumericValue(br.readLine().charAt(0));
        int[] countLeft = new int[n+1];
        int[] line = new int[n+1];
        st = new StringTokenizer(br.readLine());
//        자기보다 키가 큰 사람이 왼쪽에 몇 명이 있었는지 정보
        for (int i = 1; i <= n; i++) {
            countLeft[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            lineUp(line, countLeft[i], i);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(line[i] + " ");
        }
    }

    static void lineUp(int[] line, int countZero, int value) {
//        countZero 개수만큼 0을 찾아 건너뛰고, 다음 자리에 value를 넣음
//        countZero=2라면, 0을 두 개 찾고 다음 0의 위치에 value를 넣어야 함.
        int count = 0;
        for (int i = 1; i < line.length; i++) {
            if(line[i]==0) count++; //0 만나면 세어주고
            if(count == countZero+1) { //현재 세고있는 count가 들어가야 할 위치에 도달하면
                line[i]=value; //줄 세워주기
                break;
            }
        }
    }
}