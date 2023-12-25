public class ex4673 {
    public static void main(String[] args) {
        boolean[] notSelfNum = new boolean[10001];
        // 1~10000까지 숫자 돌면서 무한 수열 체크
        for (int i = 1; i <= 10000; i++) {
            int nextNum = nextNum(i);
            if (nextNum < 10001) notSelfNum[nextNum] = true;
        }
        for (int i = 1; i <= 10000; i++) {
            //!notSelfNum : SelfNum
            if(!notSelfNum[i]) System.out.println(i);
        }
    }
    static int nextNum(int num){
        int result = num;
        while(num!=0){
            result += num%10;
            num /= 10;
        }
        return result;
    }
}
