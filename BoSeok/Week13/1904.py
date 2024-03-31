import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())
dp = [0] *1000001
dp[1],dp[2] = 1, 2
for i in range(3, n+1):
    dp[i] = (dp[i - 2] + dp[i - 1])% 15746
print(dp[n])

# 1 : 1
# 2 : 00, 11
# 3 : 100 001 111
# 4 : 1100, 1001, 1111 1001, 0011,
