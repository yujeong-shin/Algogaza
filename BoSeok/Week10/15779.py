import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())
lst = list(map(int, sys.stdin.readline().split(" ")))

dp = [2] * n
for i in range(n - 2):
    if (lst[i] <= lst[i + 1] <= lst[i + 2]) or (lst[i] >= lst[i + 1] > lst[i + 2]):
        continue
    dp[i] = dp[i - 1] + 1
print(max(dp))
