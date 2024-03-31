import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, k = map(int, sys.stdin.readline().split(" "))

dp = [0] * (k+1)

bags = sorted([list(map(int, sys.stdin.readline().split(" "))) for _ in range(n)], key=lambda x: x[1])
for w, v in bags:
    for i in range(k, w - 1, -1):
        dp[i] = max(dp[i - w] + v, dp[i])
print(max(dp))
