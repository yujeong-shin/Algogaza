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
//            System.out.println("countLeft[i] = " + countLeft[i] + "  i = " + i);
            lineUp(line, countLeft[i], i);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(line[i] + " ");
        }
    }

    static void lineUp(int[] line, int startIndex, int value) {
        int index = -1;
        for (int i = 1; i < line.length; i++) {
            if (line[i] == 0) {
                if (startIndex == 0) {
                    index = i;
                    break;
                }
                startIndex--;
            }
        }
        line[index] = value;
    }
}

/*
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        List<Integer> result = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N; i>=1; i--){
            result.add(arr[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for(int su : result){
            sb.append(su).append(" ");
        }
        System.out.println(sb);
 */