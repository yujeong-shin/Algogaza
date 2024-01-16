import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, k = map(int,input().split())
res = []
def bt(num):
    if len(res) == k:
        print(*res)
        return
    for i in range(num, n+1):
        res.append(i)
        bt(i)
        res.pop()

bt(1)
