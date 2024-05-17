import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, k = map(int, sys.stdin.readline().split(" "))

dp = [[1 for _ in range(n + 1)] for _ in range(k + 1)]

for x in range(2, k + 1):
    for y in range(1, n + 1):
        dp[x][y] = (dp[x - 1][y] + dp[x][y - 1]) % 1000000000
print(dp[k][n])
