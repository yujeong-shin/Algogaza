import java.awt.*;
import java.util.*;
import java.util.List;

// ※주의 : 개인 프로그래머스 문제풀이 파일입니다. 주인장이 부끄러운 관계로
// 이 파일을 열고 365일 이내에 화면을 돌리지 않을 시 대머리가 되지 않습니다.
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution.gameMap(maps));
    }
    static class Solution {
        static boolean[] visited;
        public int network(int n, int[][] computers) {
            int answer = 0;
            visited = new boolean[n];
            for(int i=0; i<n; i++){
                if(!visited[i]){
                    dfs(i, n, computers);
                    answer++;
                }
            }
            return answer;
        }
        static void dfs(int start, int n, int[][] computers){
            visited[start] = true;
            for(int i=0; i<n; i++){
                if(!visited[i] && computers[start][i] == 1){
                    dfs(i,n,computers);
                }
            }
        }
        public int gameMap(int[][] maps) {
            int answer = 0;
            int[][] distance = new int[maps.length][maps[0].length];
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(0,0));
            distance[0][0] = 1;
            int[] dh = {0,1,-1,0};
            int[] dw = {-1,0,0,1};
            while(!queue.isEmpty()){
                Point point = queue.poll();
                for(int i=0; i<4; i++){
                    int nextH = point.x + dh[i];
                    int nextW = point.y + dw[i];
                    if(nextH >= 0 && nextW >= 0 && nextH < maps.length && nextW < maps[0].length && maps[nextH][nextW] == 1 && distance[nextH][nextW] == 0){
                        queue.offer(new Point(nextH,nextW));
                        distance[nextH][nextW] = distance[point.x][point.y] + 1;
                        if(nextH == maps.length-1 && nextW == maps[0].length-1) return distance[nextH][nextW];
                    }
                }
            }
            return answer -1;
        }
        public int farNode(int n, int[][] edge) {
            List<List<Integer>> list = new ArrayList<>();
            boolean[] visited = new boolean[n+1];
            int[] depth = new int[n+1];
            int answer = 0;
            for(int i=0; i<n+1; i++){
                list.add(new ArrayList<>());
            }
            for (int[] ints : edge) {
                list.get(ints[0]).add(ints[1]);
                list.get(ints[1]).add(ints[0]);
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            visited[1] = true;
            int temp = 0;
            while(!queue.isEmpty()){
                int num = queue.poll();
                for(int i : list.get(num)){
                    if(!visited[i]){
                        queue.offer(i);
                        depth[i] = depth[num] + 1;
                        if(temp < depth[i]) temp = depth[i];
                        visited[i] = true;
                    }
                }
            }
            for (int j : depth) {
                if (j == temp) answer++;
            }
            return answer;
        }
        public long Immigration(int n, int[] times) {
            long answer = 1;
            Arrays.sort(times);

            long maxTime = (long)times[times.length-1]*n;
            long minTime = 1;

            while(minTime<=maxTime){
                long averageTime = (minTime + maxTime)/2;
                long temp = 0;

                for (int time : times) {
                    temp += averageTime / time;
                    if (temp > n) break;
                }
                if(n > temp) minTime = averageTime + 1;
                else maxTime = averageTime - 1;
            }
            return minTime;
        }
        public int triangle(int[][] triangle) {
            int answer = triangle[0][0];
            int[][] newTriangle = triangle.clone();
            newTriangle[1][0] = triangle[0][0] + triangle[1][0];
            newTriangle[1][1] = triangle[0][0] + triangle[1][1];

            for(int i=2; i<triangle.length; i++){
                for(int j=0; j<triangle[i].length; j++){
                    if(j == 0) newTriangle[i][j] = triangle[i][j] + triangle[i-1][j];
                    else if(j == triangle[i].length-1) newTriangle[i][j] = triangle[i][j] + triangle[i-1][j-1];
                    else newTriangle[i][j] = triangle[i][j] + Math.max(triangle[i-1][j-1],triangle[i-1][j]);
                }
            }
            Arrays.sort(newTriangle[newTriangle.length-1]);
            answer = newTriangle[newTriangle.length-1][newTriangle[newTriangle.length-1].length-1];
            return answer;
        }
        public int third(int n) {
            int answer = 0;
            Queue<Integer> queue = new LinkedList<>();
            while(n > 0){
                queue.offer(n%3);
                n/=3;
            }
            Queue<Integer> queue1 = new LinkedList<>();
            while(!queue.isEmpty()) queue1.offer(queue.poll());

            int size = queue1.size()-1;
            while(!queue1.isEmpty()){
                int num = queue1.poll();
                answer += num * (int)Math.pow(3,size);
                size--;
            }
            return answer;
        }
        public String oneTwoThree(int n) {
            String answer = "";
            int num = n / 3;
            int num1 = n % 3;
            if(num1 == 0) {
                num--;
                num1 = 4;
            }
            if(num1 == 1) num1 = 1;
            if(num1 == 2) num1 = 2;

            if(num != 0)
                answer = num + Integer.toString(num1);
            else answer = Integer.toString(num1);
            return answer;
        }
        public int ongr(String[] babbling) {
            int answer = 0;

            return answer;
        }
        // 이분탐색?
        public int[] 뻘짓1(int[] sequence, int k) {
            int[] answer = new int[2];
            int temp = 0, count = 1;
            for(int i=sequence.length-1; i>=0; i--){
                for(int j=0; j<sequence.length; j++){
                    temp = 0;
                    for(int x=0; x<count; x++){
                        if(j+x >= sequence.length) break;
                        temp += sequence[j+x];
                        if(temp == k) {
                            answer[0] = j;
                            answer[1] = j + x;
                            return answer;
                        }
                        if(count == sequence.length) break;
                    }
                }
                count++;
            }
            return answer;
        }
        public int[] 뻘짓2(int[] sequence, int k){
            int[] answer = new int[2];
            List<Point> list = new ArrayList<>();
            for(int i=0; i<sequence.length; i++){
                int temp = 0;
                for(int j=i; j<sequence.length; j++){
                    temp += sequence[j];
                    if(temp == k) list.add(new Point(i,j));
                    if(temp > k) break;
                }
            }
            int min = Integer.MAX_VALUE;
            for (Point point : list) {
                int diff = point.y - point.x;
                if (min > diff) {
                    answer[0] = point.x;
                    answer[1] = point.y;
                    min = diff;
                }
            }
            return answer;
        }
        public int[] solution(int[] sequence, int k) {
            int[] answer = new int[2];
            List<Point> list = new ArrayList<>();
            Point p = new Point(0,0);
            int sum = sequence[0];

            while (true) {
                if (sum == k) {
                    list.add(new Point(p.x, p.y));
                    sum -= sequence[p.x];
                    p.x++;
                } else if (sum > k) {
                    sum -= sequence[p.x];
                    p.x++;
                } else {
                    p.y++;
                    if(p.y == sequence.length) break;
                    sum += sequence[p.y];
                }
            }

            int min = Integer.MAX_VALUE;
            for (Point point : list) {
                int diff = point.y - point.x;
                if (min > diff) {
                    answer[0] = point.x;
                    answer[1] = point.y;
                    min = diff;
                }
            }
            return answer;
        }
        public String[] openKakao(String[] record) {
            List<String> answer = new ArrayList<>();
            StringTokenizer st;
            Map<String, String> hashMap = new HashMap<>();

            for (int i=0; i<record.length; i++){
                st = new StringTokenizer(record[i]);
                String str = st.nextToken();
                if(str.equals("Leave")) continue;
                hashMap.put(st.nextToken(), st.nextToken());
            }

            for(String str : record){
                st = new StringTokenizer(str);
                String status = st.nextToken();
                String name = hashMap.get(st.nextToken());
                if(status.equals("Enter")){
                    answer.add(name+"님이 들어왔습니다.");
                } else if (status.equals("Leave")) {
                    answer.add(name+"님이 나갔습니다.");
                }
            }
            return answer.toArray(new String[0]);
        }
        public int[] PQ(String[] operations){
            int[] answer = new int[2];
            PriorityQueue<Integer> min_pq = new PriorityQueue<>();
            PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());

            for (String s : operations) {
                StringTokenizer st = new StringTokenizer(s);
                char operation = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (operation == 'I') {
                    min_pq.offer(num);
                    max_pq.offer(num);
                } else {
                    if (num == 1) {
                        if(!max_pq.isEmpty()) {
                            int n = max_pq.poll();
                            min_pq.remove((Integer) n);
                        }
                    } else {
                        if(!min_pq.isEmpty()) {
                            int n = min_pq.poll();
                            max_pq.remove((Integer) n);
                        }
                    }
                }
            }
            if(!max_pq.isEmpty() && !min_pq.isEmpty()){
                answer[0] = max_pq.peek();
                answer[1] = min_pq.peek();
            }
            return answer;
        }
    }
}
