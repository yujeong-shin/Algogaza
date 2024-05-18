import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex1389_케빈베이컨_플로이드워셜 {
    static final int INF = 999999999;
    static int N, M;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N+1][N+1];

        // 초기값 설정
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                }
                dist[i][j] = INF;
            }
        }
        // 연결 정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = dist[b][a] = 1;
        }
        // 플로이드-워셜 알고리즘 : 거쳐가는 정점을 기준으로 최단 거리
        // https://m.blog.naver.com/PostView.nhn?blogId=ndb796&logNo=221234427842&proxyReferer=https:%2F%2Fwww.google.com%2F
        for (int k = 1; k <= N; k++) { // 거쳐 갈 노드 번호
            for (int i = 1; i <= N; i++) { // x좌표
                for (int j = 1; j <= N; j++) { // y좌표
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 케빈 베이컨의 수가 가장 작은 인덱스를 탐색
        int count = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += dist[i][j];
            }

            if (count > sum) {
                count = sum;
                index = i;
            }
        }
        System.out.println(index);
    }
}
