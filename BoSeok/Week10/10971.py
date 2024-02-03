import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())

graph = [list(map(int, sys.stdin.readline().split(" "))) for _ in range(n)]
cost = 0
ans = 1e9
visited = [False] * n

def dfs(depth, y):
    global cost, ans
    if depth == n - 1: # 시작지점 빼고 방문 다 했을때
        if graph[y][0]: # 시작 지점으로 오는게 가능하다면
            cost += graph[y][0] # 외판선 순회 가능이니 비용 더해주고
            ans = min(cost, ans) # 최솟값 갱신
            cost -= graph[y][0] # 다른것도 확인해봐야하니 빼주고 리턴
        return

    for i in range(1, n):
        if not visited[i] and graph[y][i]: # 방문하지 않았고, 갈 수 있으면
            visited[i] = True # 방문처리
            cost += graph[y][i] # 비용늘리고
            dfs(depth + 1, i) # 다음꺼 하러 출발
            visited[i] = False
            cost -= graph[y][i]


dfs(0, 0) # 깊이와 순회도시 0번 시작
print(ans)
