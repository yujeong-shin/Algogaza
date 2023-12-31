import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex1063_킹 {
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};

    //ordinal() : 원소에 열거된 순서를 정수 값으로 리턴
    public enum Move {
        R, L, B, T, RT, LT, RB, LB;
    }
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int[] king = new int[2];
        int[] stone = new int[2];

//        킹의 초기 위치 세팅
        String kingXY = st.nextToken();
        initObjectXY(kingXY, king);
//        돌의 초기 위치 세팅
        String stoneXY = st.nextToken();
        initObjectXY(stoneXY, stone);

        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String func = br.readLine();
//            System.out.println("func : " + func);
//            움직임 정보의 인덱스 값 받아오기 ex) func="B"이면 2
            int index = Move.valueOf(func).ordinal();
//            System.out.println("index : " + index);
//            System.out.println("Move에서 가져온 이동 정보 : " + dx[index] + ", " + dy[index]);
//            king의 다음 위치
            int kingNX = king[0] + dx[index];
            int kingNY = king[1] + dy[index];
//            System.out.println("king의 다음 위치 : " + kingNX + kingNY);
//             king의 다음 위치가 체스판 밖이면 움직이지 않음
//            king은 문자(아스키코드)로 처리하기 때문에 숫자값 적절하게 설정
            if(kingNX<65 || kingNX>72 || kingNY<1 || kingNY>8) continue;

//            king의 다음 위치에 stone이 있는 경우
//            stone먼저 이동 후 king 이동(이때 stone 범위 체크, stone은 범위 내에 존재하기 때문에 king 범위는 체크 안해도 무방)
            if(kingNX==stone[0] && kingNY==stone[1]){
//                System.out.println("이동 중에 돌이 있음");
//                System.out.println("stone 이동 후 king 이동");
                int stoneNX = stone[0] + dx[index];
                int stoneNY = stone[1] + dy[index];
//                stone 다음 위치가 체스판 밖이면 움직이지 않음
                if(stoneNX<65 || stoneNX>72 || stoneNY<1 || stoneNY>8) continue;
                else{
                    stone[0] = stoneNX;
                    stone[1] = stoneNY;
                    king[0] = kingNX;
                    king[1] = kingNY;
                }
            }
            else{
//            king의 다음 위치에 stone이 없는 경우, king만 이동
//                System.out.println("king만 이동");
                king[0] = kingNX;
                king[1] = kingNY;
            }
        }
        System.out.println(makeAnswer(king));
        System.out.println(makeAnswer(stone));
    }

    static void initObjectXY(String strXY, int[] object){
        object[0] = strXY.charAt(0); //int형이기 때문에 A -> 65 이런식으로 대입됨
        object[1] = Character.getNumericValue(strXY.charAt(1));
    }
    static StringBuilder makeAnswer(int[] object){
        StringBuilder answer = new StringBuilder();
        answer.append((char)object[0]);
        answer.append(object[1]);
        return answer;
    }
}

