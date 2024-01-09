import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')
n ,m = map(int,sys.stdin.readline().split(" "))
res = []
def bt(node):
    if len(res) == m:
        print(*res)
        return

    for i in range(1,n+1):
        if i not in res:
            res.append(i)
            bt(i)
            res.pop()
bt(0)
