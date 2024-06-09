import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

t = int(input())
dp = [0, 0, 1, 7, 4, 2, 6, 8, 10] + [1e9] * 92
# 2~7개 로 만들 수 있는 가장 작은 수
add_rule = [1, 7, 4, 2, 0, 8]

for n in range(9, 101):
    dp[n] = min(
        # 2개로 만들고, 7개로 만든수 뒤에 붙임 밑에는 동일
        dp[n - 7] * 10 + add_rule[5],
        dp[n - 6] * 10 + add_rule[4],
        dp[n - 5] * 10 + add_rule[3],
        dp[n - 4] * 10 + add_rule[2],
        dp[n - 3] * 10 + add_rule[1],
        dp[n - 2] * 10 + add_rule[0]
    )

def find_small(i):
    return dp[i]


def find_large(i):
    if i % 2 == 0:
        return "1" * (i // 2)
    else:
        return "7" + "1" * ((i - 3) // 2)


for _ in range(t):
    i = int(input())
    x = find_small(i)
    y = find_large(i)
    print(x, y)
