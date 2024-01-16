import sys
from itertools import product

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

# 풀이 1.
n, k = map(int,input().split())
for i in list(product([i for i in range(1,n+1)],repeat=k)):
    print(*i)

# 풀이 2.
res = []
def bt(num):
    if len(res) == k:
        print(*res)
        return
    for i in range(1,n+1):
        res.append(i)
        bt(i+1)
        res.pop()
bt(0)