import sys
from collections import deque

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

A, B, N, M = map(int, sys.stdin.readline().split(" "))

dp = [-1] * 100001
# 시작점 N
dp[N] = 0
Q = deque()
Q.append(N)

while Q:
    node = Q.popleft()
    # 8가지방향 포문 돌리기
    for nx in ([node + 1, node - 1, node + A, node - A, node + B, node - B, node * A, node * B]):
        # 위치 조건
        if 0 <= nx <= 100000 and dp[nx] == -1:
            # 맞으면 넣고
            Q.append(nx)
            # 거리 최신화
            dp[nx] = dp[node]+1
            # 도착시 종료
            if nx == M:
                break
print(dp[M])
