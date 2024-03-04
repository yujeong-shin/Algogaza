import sys
from collections import deque

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, m = map(int, sys.stdin.readline().split(" "))
graph = [list(map(str, input())) for _ in range(n)]
move = [(0, 1), (0, -1), (1, 0), (-1, 0)]
res = -1e9


def bfs(a, b):
    Q = deque([(a, b)])
    visited = [[0] * m for _ in range(n)]
    visited[a][b] = 1
    count = 0
    while Q:
        x, y = Q.popleft()
        for dx, dy in move:
            nx = x + dx
            ny = y + dy
            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == "L" and not visited[nx][ny]:
                visited[nx][ny] = visited[x][y] + 1
                count = max(count, visited[nx][ny])
                Q.append((nx,ny))
    return count

for x in range(n):
    for y in range(m):
        if graph[x][y] == "L":
            res = max(res, bfs(x, y))

print(res-1)
