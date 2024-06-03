import sys
from collections import deque

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

M, N = map(int, input().split(" "))

map = [list(map(int, input().split())) for i in range(N)]  # 문제 그대로 가져옴
move = [(0, 1), (0, -1), (1, 0), (-1, 0)]  # 이동방향 상하좌우
Q = deque([])
for i in range(N):
    for j in range(M):
        if map[i][j] == 1:
            Q.append([i, j])

while Q:
    x, y = Q.popleft()
    for a, b in move:
        nx, ny = x + a, y + b
        if 0 <= nx < N and 0 <= ny < M and map[nx][ny] == 0:
            Q.append((nx, ny))
            map[nx][ny] = map[x][y] + 1

res = 0
for i in map:
    if 0 in i:
        print(-1)
        exit()
    res = max(res, max(i))
print(res - 1)
