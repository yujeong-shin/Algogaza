import sys
from collections import deque

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, m = map(int, sys.stdin.readline().split(" "))
graph = [list(map(str, sys.stdin.readline().rstrip())) for _ in range(n)]
visited = [[[False] * m for _ in range(n)] for _ in range(64)]
# 이동방향
move = [(0, 1), (0, -1), (1, 0), (-1, 0)]
# 시작 좌표
Q = deque()
for x in range(n):
    for y in range(m):
        if graph[x][y] == "0":
            Q.append((x, y, 0, 0))  # x, y 좌표 이동수, 키 상태
            graph[x][y] = "."
while Q:
    x, y, move_count, key_list = Q.popleft()
    visited[0][x][y] = True
    for dx, dy in move:
        nx = dx + x
        ny = dy + y
        # 범위 안,
        if 0 <= nx < n and 0 <= ny < m and not visited[key_list][nx][ny]:
            # 도착
            print(nx, ny,key_list)
            if graph[nx][ny] == "1":
                print(move_count + 1)
                exit()
            # 그냥 지나갈수 있음
            elif graph[nx][ny] == ".":
                visited[key_list][nx][ny] = True
                Q.append((nx, ny, move_count + 1, key_list))
            # key를 만나면 챙겨야지
            elif graph[nx][ny] in ['a', 'b', 'c', 'd', 'e', 'f']:
                # 키 의 값을 알게됨 d 면 왼쪽 3 칸 밀어야지요
                n_key = key_list | (1 << (ord(graph[nx][ny]) - ord('a')))
                visited[n_key][nx][ny] = True
                Q.append((nx, ny, move_count + 1, n_key))
            # 문이면? 키 있는지 체크 >> 비트마스킹으로 체킹
            elif graph[nx][ny] in ['A', 'B', 'C', 'D', 'E', 'F']:
                # 둘다 있음
                if key_list & (1 << (ord(graph[nx][ny]) - ord('A'))):
                    visited[key_list][nx][ny] = True
                    Q.append((nx, ny, move_count + 1, key_list))
print(-1)
# 문을 만나면 & 로 체크
# 키를 만나면 | 로 두개 다 챙김
