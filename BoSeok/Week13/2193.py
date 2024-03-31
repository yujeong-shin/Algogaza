import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())

dp = [0, 1, 1] * (n + 1)
for i in range(2, n + 1):
    dp[i] = dp[i - 1] + dp[i - 2]
print(dp[n])

# 1
# 10

# 101, 100
#
# 1010,1000,1001
#
# 10100,10101, 10000,10001, 10010
