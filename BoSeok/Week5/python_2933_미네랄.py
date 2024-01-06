import sys
from collections import deque

sys.stdin = open('/Users/song/Desktop/Github/Algogaza/input', 'r')

r, c = map(int, sys.stdin.readline().split(" "))
graph = [list(map(str, sys.stdin.readline().rstrip())) for _ in range(r)]
n = int(input())
height = list(map(int, sys.stdin.readline().split(" ")))
move = [(1, 0), (-1, 0), (0, -1), (0, 1)]
Q = deque()


# 하나 제거후 클러스터 상하좌우 미네랄 있는지 확인
def stick(i, flag):
    # 짝수 왼쪽에서 쏠때
    i = r - i
    j = 0
    # 왼쪽에서 날라옴
    if flag == 1:
        for k in range(c):
            if graph[i][k] == "x":
                graph[i][k] = "."
                j = k
                break
    # 오른쪽에서 날라옴
    else:
        for k in range(c - 1, -1, -1):
            if graph[i][k] == "x":
                j = k
                graph[i][k] = "."
                break
    # 깨진 거 기준 싱히좌우 미네랄 확인
    for dx, dy in move:
        nx = dx + i
        ny = dy + j
        if 0 <= nx < r and 0 <= ny < c:
            if graph[nx][ny] == "x":
                Q.append((nx, ny))
#   깨진 미네랄 상하좌우의 미네랄 리턴



# 없어진 미네랄 기준 생긴 클러스터 확인,
def lets_go_fall_visited(fall, visited):
    # 내려갈 수 있는 범위 체크 해줌
    # flag 바뀌면 바닥이라 못 내려감
    down, flag = 1, False
    while True:
        for i, j in fall:
            # down칸 내려가면 바닥일 경우
            if i + down == r - 1:
                flag = True
                break
            # 현재위치에서 donw+1 내려갔을때 다른 미네랄이 있으면 안됨.
            if graph[i + down + 1][j] == 'x' and not visited[i + down + 1][j]:
                flag = True
                break
        if flag:
            break
        down += 1
    # 교체해주기
    for i in range(r - 2, -1, -1):
        for j in range(c):
            if graph[i][j] == 'x' and visited[i][j]:
                graph[i][j] = '.'
                graph[i + down][j] = 'x'


def bfs(x, y):
    q = deque()
    visited = [[0] * c for _ in range(r)]
    fall = []
    q.append([x, y])
    visited[x][y] = 1
    while q:
        x, y = q.popleft()
        # 바닥이면 어차피 못 내려감
        if x == r - 1:
            return
        # 각 열 마다 가장 아래에 있는 x,y좌표 가져옴
        if graph[x + 1][y] == '.':
            fall.append([x, y])
        # 각 열마다 가장 아래 좌표까지 가기위해 탐색
        for dx, dy in move:
            nx = x + dx
            ny = y + dy
            if 0 <= nx < r and 0 <= ny < c and graph[nx][ny] == 'x' and not visited[nx][ny]:
                visited[nx][ny] = 1
                q.append([nx, ny])
    # 그렇게 해서 나온 떨어진 클러스터의 가장 아래에 있는 좌표들과, 미네랄 좌표 체크리스트 들고감
    # 없으면 밑에 조차 안감.
    lets_go_fall_visited(fall, visited)


left = 1
for index in height:
    # 미네랄 한개제거, 제거된 미네랄 기준 상하좌우 체크
    stick(index, left)
    while Q:
        x, y = Q.popleft()
        bfs(x, y)
    left *= -1
    break
for lst in graph:
    print("".join(lst))
