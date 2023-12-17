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

		int result = bfs(a, b);

		System.out.println(result);
	}

	static int bfs(int a, int b) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(a);

		int count = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int current = queue.poll();

				if (current == b) {
					return count + 1;
				}

				if (current * 2 <= b) {
					queue.add(current * 2);
				}

				if (current * 10 + 1 <= b) {
					queue.add(current * 10 + 1);
				}
			}

			count++;
		}

		return -1;
	}
}