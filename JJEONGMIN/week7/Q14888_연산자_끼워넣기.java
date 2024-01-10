import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14888_연산자_끼워넣기 {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException, ScriptException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int[] operArr = new int[4];
        for(int i=0; i<4; i++){
            // 0 : 덧셈, 1 : 뺄셈, 2: 곱셈, 3: 나눗셈
            operArr[i] = Integer.parseInt(st.nextToken());
        }


        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = engine.eval("4*5");
        System.out.println(result);
    }
}
