import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ex1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Deque<Document> deque = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            // 큐에 문서 정보를 넣을 때, 몇 번째 인덱스인지 저장
            for (int j = 0; j < n; j++) {
                int importanceOfDoc = Integer.parseInt(st.nextToken());
                deque.addLast(new Document(j, importanceOfDoc));
            }

            int cnt = 0;
            while (true) {
                Document now = deque.removeFirst();
                boolean isMostImportant = true;

                for (Document others : deque) {
                    if (now.importance < others.importance) {
                        isMostImportant = false;
                        break;
                    }
                }

                if (isMostImportant) {
                    cnt++;
                    if (now.index == m) break;
                } else {
                    deque.addLast(now);
                }
            }

            System.out.println(cnt);
        }
    }

    static class Document {
        int index;
        int importance;
        public Document(int index, int importance) {
            this.index = index;
            this.importance = importance;
        }
    }
}