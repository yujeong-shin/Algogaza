import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, m = map(int, sys.stdin.readline().split(" "))
graph = [list(map(int, sys.stdin.readline().rstrip().split(" "))) for _ in range(n)]

move = [(1, 0), (-1, 0), (0, 1), (0, -1)]

# 모든 경로 0 으로 초기화
# 각 좌표 별로 갈 수 있는 경로 최댓값 저장 예정
dp = [[-1 for _ in range(m)] for _ in range(n)]


def dfs(x, y):
    # 목적지에  오면 지나온 자리들 다 +1 해줌
    if x == n - 1 and y == m - 1:
        return 1
    # 미 방문 지역 이면
    if dp[x][y] == -1:
        # 방문처리해주고
        dp[x][y] = 0
        # 방문할곳 체크
        for dx, dy in move:
            nx = x + dx
            ny = y + dy
            # 더 작은 수 이면 방문 가능
            if 0 <= nx < n and 0 <= ny < m:
                if graph[x][y] > graph[nx][ny]:
                    # 지나온 길 더해주기,
                    dp[x][y] += dfs(nx, ny)
    return dp[x][y]


print(dfs(0, 0))
