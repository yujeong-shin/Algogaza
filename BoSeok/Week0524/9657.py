import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())

dp = [-1, 1, 0, 1, 1]
if n == 1:
    print('SK')
elif n == 2:
    print('CY')
elif n == 3:
    print('SK')
elif n == 4:
    print('SK')
else:
    for i in range(5, n + 1):
        if dp[i - 1] == 0 or dp[i - 3] == 0 or dp[i - 4] == 0:
            dp.append(1)
        else:
            dp.append(0)
    print("SK" if dp[n] == 1 else "CY")
