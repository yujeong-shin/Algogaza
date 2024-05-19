import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())

dp = [[0, 0, 0] for _ in range(n + 1)]
dp[1][0] = dp[1][1] = dp[1][2] = 1

for i in range(2, n + 1):
    # 아무것도 사용 안 하는경우, 모두 다가능
    dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2])% 9901
    # 왼족꺼 선택하는 경우, 아무것도 없을때 오거나, 오른쪽에서 오거나
    dp[i][1] = (dp[i - 1][0] + dp[i - 1][2])% 9901
    # 오른족꺼 선택하는 경우, 아무것도 없을때 오거나, 왼쪽에서 오거나
    dp[i][2] = (dp[i - 1][0] + dp[i - 1][1])% 9901

print(sum(dp[n])% 9901)
