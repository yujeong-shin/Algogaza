// A -> B
// ㅠ 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int result = min(a, b);

		System.out.println(result);
	}

	static int min(int a, int b) {
		int count = 0;

		if (b <= a) {
			return -1;
		}

		while (b > a) { // b->a
			// b가 홀수면 끝에 1 추가 불가
			if (b % 2 == 0) {
				b /= 2;
			} else if (b % 10 == 1) { // b의 끝자리가 1이면 1 제거
				b /= 10;
			} else {
				return -1;
			}

			count++;
		}
		if (a != b) { // a에서 b를 만들 수 없는 경우
			return -1;
		}

		return count + 1;
	}
}