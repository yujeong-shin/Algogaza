import sys
from collections import deque

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, m = map(int, sys.stdin.readline().split(" "))

graph = [list(sys.stdin.readline().rstrip()) for _ in range(n)]
visited = [[False] * m for _ in range(n)]
move = [(0, 1), (0, -1), (1, 0), (-1, 0)]
Q = deque()
for i in range(n):
    for j in range(m):
        if graph[i][j] == "I":
            Q.append((i, j))
res = 0
while Q:
    x, y = Q.popleft()
    for dx, dy in move:
        nx = x + dx
        ny = y + dy
        if 0 <= nx < n and 0 <= ny < m:
            if graph[nx][ny] != 'X' and not visited[nx][ny]:
                Q.append((nx, ny))
                visited[nx][ny] = True
                if graph[nx][ny] == 'P':
                    res += 1

print(res if res > 0 else 'TT')
