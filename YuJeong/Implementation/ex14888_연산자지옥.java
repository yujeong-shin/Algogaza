import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex14888_연산자지옥 {
    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] num, oper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        oper = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        DFS(1, num[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void DFS(int numIdx, int res){
        if(numIdx == N){
            max = Math.max(max, res);
            min = Math.min(min, res);
        }
        else {
            for (int operIdx = 0; operIdx < 4; operIdx++) {
                if(oper[operIdx] > 0) { // 사용 가능한 연산자가 있다면
                    oper[operIdx]--;

                    int curRes = res;
                    if(operIdx==0) { // 더하기
                        DFS(numIdx+1, curRes + num[numIdx]);
                    }
                    else if(operIdx==1) { // 빼기
                        DFS(numIdx+1, curRes - num[numIdx]);
                    }
                    else if(operIdx==2) { // 곱하기
                        DFS(numIdx+1, curRes * num[numIdx]);
                    }
                    else { // 나누기
                        // 나눌 값이 음수라면 양수로 바꾼 뒤 몫을 구하고, 몫을 음수로 바꾸기
                        if(curRes < 0) {
                            curRes = -(curRes);
                            DFS(numIdx+1, (curRes / num[numIdx]) * -1);
                        }
                        else {
                            DFS(numIdx+1, curRes / num[numIdx]);
                        }
                    }
                    oper[operIdx]++;
                }
            }
        }
    }
}
