import sys
from collections import deque

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

c, r = map(int, sys.stdin.readline().split())
k = int(input())

# 상 우 하 좌
direction = [(-1, 0), (0, 1), (1, 0), (0, -1)]

# 값이 클때 그냥 끝냄
if k > c * r:
    print(0)
    exit()
# 모든 좌표 0으로 선언
graph = [[0] * c for _ in range(r)]


def slide():
    # 시작점과, 위로 향하게 함
    x, y = r - 1, 0
    graph[x][y] = 1
    idx = 0
    # while문 시작
    while True:
        # 이전 값 저장, 다음값에 이전값 + 1 을 해주기 위함
        temp = graph[x][y]
        # 한 바퀴 다 돌았을때 break
        if temp == r * c:
            break
        # 설정된 방향으로 쭊쭊 감
        nx = x + direction[idx % 4][0]
        ny = y + direction[idx % 4][1]
        # 범위를 벗어나거나, 이미 방문한 곳이면 방향을 바꿔줘야함
        if nx < 0 or nx >= r or ny < 0 or ny >= c or graph[nx][ny] != 0:
            idx += 1
            continue
        # 이전꺼에 +1
        graph[nx][ny] = temp + 1
        # 다음 좌표를 바꿔줘야함
        x = nx;
        y = ny
    return graph


slide()
for x in range(r):
    for y in range(c):
        if graph[x][y] == k:
            print(y + 1, r - x)
