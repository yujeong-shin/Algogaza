import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())

dp = [0, 1]

for i in range(2, abs(n) + 1):
    dp.append((dp[i - 1] + dp[i - 2]) % 1000000000)
if n < 0 and n % 2 == 0:
    print(-1)
elif n == 0:
    print(0)
else:
    print(1)
print(dp[abs(n)])
