// 사탕 게임

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_3085 {
	static int max = 0;
	static int n;
	static char[][] arr = new char[50][50];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine()); 

		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				swapx(i, j); // 가로로 인접한 두 사탕 교환
				check();
				swapx(i, j); // 교환한 사탕 원위치
			}
		}
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n - 1; i++) {
				swapy(i, j); // 세로로 인접한 두 사탕 교환
				check();
				swapy(i, j);
			}
		}
		System.out.println(max);
	}

	public static void check() {
		int tmp = 0;
		// 가로 방향으로 연속된 사탕개수 확인
		for (int i = 0; i < n; i++) {
			tmp = 1;
			for (int j = 0; j < n - 1; j++) {
				if (arr[i][j] == arr[i][j + 1])
					tmp++;
				else
					tmp = 1;
				if (tmp > max)
					max = tmp;
			}
		}
		// 세로 방향으로 연속된 사탕개수 확인
		for (int j = 0; j < n; j++) {
			tmp = 1;
			for (int i = 0; i < n - 1; i++) {
				if (arr[i][j] == arr[i + 1][j])
					tmp++;
				else
					tmp = 1;
				if (tmp > max)
					max = tmp;
			}
		}
	}

	private static void swapy(int i, int j) {
		char temp = arr[i][j];
		arr[i][j] = arr[i + 1][j];
		arr[i + 1][j] = temp;
	}

	private static void swapx(int i, int j) {
		char temp = arr[i][j];
		arr[i][j] = arr[i][j + 1];
		arr[i][j + 1] = temp;
	}
}
