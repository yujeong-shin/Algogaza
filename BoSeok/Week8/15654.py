import sys
from itertools import combinations, product

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, k = map(int,input().split())
lst = sorted(list(map(int,sys.stdin.readline().split(" "))))
res = []
def bt(num):
    if len(res) == k:
        print(*res)
        return
    for i in range(n):
        if lst[i] in res:
            continue
        res.append(lst[i])
        bt(num+1)
        res.pop()
bt(0)