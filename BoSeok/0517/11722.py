import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())
lst = list(map(int, sys.stdin.readline().split(" ")))

# 자기 자신만 선택했을 경우 1로 dp 최신화
dp = [1 for _ in range(n)]

# 총 길이
for i in range(n):
    # 앞에서 부터 그 길이까지
    for j in range(i):
        # 만약에 감소한다 ?
        if lst[i] < lst[j]:
            # 그러면 dp의 값을 최댓값으로 바꿔줌.
            dp[i] = max(dp[i], dp[j] + 1)
print(max(dp))

