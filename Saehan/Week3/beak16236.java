import java.util.*;

public class beak16236 
{
    static int N, sec;
    static int graph[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static Node sharkPos;
    static int sharkSize = 2;
    static int sharkAte = 0;

    public static void main(String[] args)
    {
//        조건
//        먹을 물고기가 없으면 도움요청
//        먹을 수 있는 물고기가 1마리면, 그거 먹으러
//        먹을 수 있는게 2마리 이상이면, 가장 가까운거로
//        아기상어에서 물고기로 이동할때 칸의 최솟값이 거리
//        거리가 가까운 물고기가 많으면 맨 위에, 맨위가 여러개면, 가장 왼쪽물고기
//        먹으면 빈 칸 (0)
//        상어가 자기 크기만큼 먹으면 사이즈 1 증가
//        상어가 도움없이 물고기가 가능한지 출력
//         자기보다 큰 물고기는 못지나감
//         자기보다 작은 물고기만 먹을 수 있음 -> 같은 크기는 못먹지만 지나는 감
//         아기상어=2, 1초 상하좌우 갈수있는곳
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //공간 - 1 by 1 공간에 물고기 최대 1마리
        graph = new int[N][N];

        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                graph[i][j] = sc.nextInt();
                if(graph[i][j] == 9) // 상어위치 저장
                {
                    sharkPos = new Node(i, j, 0);
                    graph[i][j] = 0;
                }
            }
        }
//        System.out.println(Arrays.deepToString(graph));

        sec = 0;
        while(true)
        {
            PriorityQueue<Node> pq = getFishesDist();
            if(pq.isEmpty()) //물고기 없으면 끝
                break;
            Node fish = pq.poll();
            sec += fish.distance;
            sharkAte++;
            if(sharkAte == sharkSize)
            {
                sharkSize++;
                sharkAte = 0;
            }
            sharkPos.x = fish.x;
            sharkPos.y = fish.y;
            graph[sharkPos.x][sharkPos.y] = 0;
        }
        System.out.println(sec);
    }

    static PriorityQueue<Node> getFishesDist() //큐에서 우선순위 큐에 물고기들 정렬넣기 / 물고기별 거리계산
    {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean visited[][] = new boolean[N][N];
        Queue<Node> queue = new LinkedList<>();
        queue.add(sharkPos);
        visited[sharkPos.x][sharkPos.y] = true;

        while(!queue.isEmpty())
        {
            Node current = queue.poll();
            //상어가 먹을 수 있나 / 갈 수 있나 체크후 우선순위큐에 넣기
            if(graph[current.x][current.y] > 0 && graph[current.x][current.y] < sharkSize)
                pq.add(new Node(current.x, current.y, current.distance));

            for(int i = 0; i < dx.length; i++)
            {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && graph[nx][ny] <= sharkSize) //사이즈가 같아도 통과
                {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny, current.distance + 1));
                }
            }
        }
        return pq;
    }

    static class Node implements Comparable<Node>
    {
        int x, y, distance;

        Node(int x, int y, int distance)
        {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o)
        {
            if(this.distance != o.distance)
                return this.distance - o.distance;
            else if(this.x != o.x)
                return this.x - o.x;
            else
                return this.y - o.y;
        }
    }        
}