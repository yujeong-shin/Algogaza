import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex2477_참외밭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[6];
        int MaxWidthIndex=0,MaxWidth=0,MaxHeightIndex=0,MaxHeight=0;
        for(int i=0;i<6;i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());
            //가장 긴 가로의 길이와 위치 찾기
            if((d==1 || d==2)&& MaxWidth<arr[i]) {
                MaxWidth = arr[i];
                MaxWidthIndex = i;
            }
            //가장 긴 세로의 길이와 위치 찾기
            else if((d==3 || d==4)&& MaxHeight<arr[i]){
                MaxHeight = arr[i];
                MaxHeightIndex = i;
            }
        }

        int len1, len2, minWidth, minHeight;
        // 가장 긴 가로길이 양 옆 변의 차 == 빈 사각형의 세로 길이
        if(MaxWidthIndex + 1 == 6) len1=0;
        else len1 = MaxWidthIndex + 1;

        if(MaxWidthIndex - 1 == -1) len2=5;
        else len2 = MaxWidthIndex - 1;
        minHeight=Math.abs(arr[len1]-arr[len2]);

        // 가장 긴 세로길이 양 옆 변의 차 == 빈 사각형의 가로 길이
        if(MaxHeightIndex + 1 == 6) len1=0;
        else len1 = MaxHeightIndex + 1;

        if(MaxHeightIndex - 1 == -1) len2=5;
        else len2 = MaxHeightIndex - 1;
        minWidth=Math.abs(arr[len1]-arr[len2]);

        System.out.println(((MaxWidth*MaxHeight)-(minHeight*minWidth)) * N);
    }
}
