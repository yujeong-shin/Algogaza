import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

N = int(input())
for i in range(N):
    n, m, x, y = map(int, sys.stdin.readline().split(" "))
    k = x
    while k <= n*m:
        if (k-x) % n == 0 and (k-y)%m == 0:
            print(k)
            break
        k += n
    else:
        print(-1)
