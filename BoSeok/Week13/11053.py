import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())

A = list(map(int, sys.stdin.readline().split(" ")))

dp = [1] * n

for x in range(n):
    for y in range(x):
        if A[x] > A[y]:
            dp[x] = max(dp[x], dp[y] + 1)
print(max(dp))
# 최댓값을 계속 갱신
