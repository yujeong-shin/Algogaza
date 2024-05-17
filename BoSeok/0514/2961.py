import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())

lst = [list(map(int, sys.stdin.readline().split(" "))) for _ in range(n)]

res = 1e9
temp = []

def bt(start, depth, target):
    global res
    if depth == target:
        s, r= 1,0
        for ss, rr in temp:
            s *= ss
            r += rr
        res = min(res, abs(s-r))
        return
    for idx in range(start, n):
        temp.append(lst[idx])
        bt(idx+1, depth + 1, target)
        temp.pop()


for i in range(1, n + 1):
    bt(0, 0, i)
print(res)
