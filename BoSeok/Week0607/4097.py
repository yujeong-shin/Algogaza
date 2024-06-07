import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

while True:
    try:
        n = int(input())
        if n == 0:
            break
        lst = [int(input()) for _ in range(n)]
        for i in range(1, n):
            lst[i] = max(lst[i - 1] + lst[i], lst[i])
        print(max(lst))
    except:
        print(exit())
