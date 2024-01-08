package HiJaeYoung.week6;

import java.util.Scanner;

public class Num1193_분수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i =1;
        while(n>0){
            n -=i;
            i++;
        }
        if(n==0){
            i-=1;
            printAnswer(i);
        }else{
            i--;
            printAnswer(i,n);
        }
    }
    public static void printAnswer(int i){
        if(i%2==0){
            System.out.println(i+"/"+1);
        }else{
            System.out.println(1+"/"+i);
        }
    }
    public static void printAnswer(int i,int n){
        if((i)%2==0){
            System.out.println((i+n)+"/"+(1-n));
        }else{
            System.out.println((1-n)+"/"+(i+n));
        }
    }
}
