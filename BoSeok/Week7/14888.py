import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())
lst = list(map(int, sys.stdin.readline().split(" ")))
cal = list(map(int, sys.stdin.readline().split(" ")))
a, b, c, d = cal

max_res = -100000000
min_res = 1000000000


def bt(a, b, c, d, res, idx):
    global max_res, min_res
    # 사칙연산 다썼을경우
    if idx == n:
        max_res = max(max_res, res)
        min_res = min(min_res, res)

    # 덧셈
    if a > 0:
        bt(a - 1, b, c, d, res + lst[idx], idx + 1)
    # 뺄셈
    if b > 0:
        bt(a, b - 1, c, d, res - lst[idx], idx + 1)
    # 곱셈
    if c > 0:
        bt(a, b, c - 1, d, res * lst[idx], idx + 1)
    # 나눗셈
    if d > 0:
        bt(a, b, c, d - 1, int(res / lst[idx]), idx + 1)


# 시작값 맨앞은 lst[0] 이 들어가고 시작한다.
# 인덱스도 1을 넣는다.
bt(a, b, c, d, lst[0], 1)
print(max_res, min_res, sep="\n")
