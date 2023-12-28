public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution.solution(n, computers));
    }
    static class Solution {
        static boolean[] visited;
        public int solution(int n, int[][] computers) {
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
    }
}
