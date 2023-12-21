import java.util.Arrays;

public class Q4673 {
    static int[] array;
    public static void main(String[] args) {
        array = new int[10002];
        for(int i=1; i<=10000; i++){
            selfNum(i);
        }
        for(int i=1; i<=10000; i++){
            if(array[i] == 0)
                System.out.println(i);
        }
    }
    private static void selfNum(int n) {
        if(n >= 10000) return;
        int sum = 0, curNum = n;
        while(curNum > 0) {sum += curNum%10; curNum /= 10;}
        if(n+sum <= 10000){
            array[n+sum] = 1;
        }
        selfNum(n+sum);
    }
}
