package HiJaeYoung.week7;

// 계란은 내구도와 무게를 가진다.
// 두 계란이 부딪히면 각 계란의 내구도는 상대 계란의 무게만큼 깎인다.

// 문제 정리
// 1. 가장 왼쪽 계란 스탓트
// 2. 다른 계란 중 하나와 박치기
//      단, 깰 계란이 없으면 패스
// 3. 최근 계란의 오른쪽 계란을 들고 2로 돌아감
//      단, 든 계란이 깨진 계란이면 패스~
// 4. 만일 오른쪽 계란이 없으면 종료

// input
// N<=8 개꿀

// output
// 최대로 깰 수 있는 계란 => 모든 경우 다 봐야겠지?

// 백트랙킹을 이용한 모든 경우 확인
//


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num16987_인범이3대500 {
    private static class Egg{
        int hp;
        int weight;
        boolean isBroken;
        public Egg(int hp,int weight){
            this.hp = hp;
            this.weight = weight;
            this.isBroken =false;
        }

        public int crush(Egg otherEgg){
            if(this.isBroken || otherEgg.isBroken){return 0;}
            int num =0;
            this.hp -= otherEgg.weight;
            otherEgg.hp -= this.weight;
            if(this.hp<=0){
                this.isBroken =true;
                num++;
            }
            if(otherEgg.hp<=0){
                otherEgg.isBroken=true;
                num++;
            }
            return num;
        }

        public int rollback(Egg otherEgg){
            int num =0;
            this.hp += otherEgg.weight;
            otherEgg.hp += this.weight;
            if(this.hp>0 && this.isBroken){
                this.isBroken =false;
                num++;
            }
            if(otherEgg.hp>0 && otherEgg.isBroken){
                otherEgg.isBroken=false;
                num++;
            }
            return -1*num;
        }
    }
    static Egg[] eggs;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int eggNum = Integer.parseInt(st.nextToken());
        eggs = new Egg[eggNum+1];
        answer = 0;
        for(int i=1;i<=eggNum;i++){
            st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        solution(eggNum,1,0);
        System.out.println(answer);
    }

    public static void solution(int eggNum,int nowEggNum,int brokenEgg){
        answer = Math.max(answer,brokenEgg);
        if(nowEggNum>eggNum){
            return;
        }
        if(eggs[nowEggNum].isBroken){
            solution(eggNum,nowEggNum+1,brokenEgg);
            return;
        };
        for(int i=1;i<=eggNum;i++){
            if(i==nowEggNum) continue;
            if(!eggs[i].isBroken){
                brokenEgg +=eggs[nowEggNum].crush(eggs[i]);
                solution(eggNum,nowEggNum+1,brokenEgg);
                brokenEgg +=eggs[nowEggNum].rollback(eggs[i]);
            }
        }
    }
}
