import sys
from itertools import combinations

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())
graph = [list(map(int,sys.stdin.readline().split(" "))) for _ in range(n)]
res = 1e9
visited = [False]*n


def cal():
    global res
    left, right = 0,0
    for x in range(n):
        for y in range(n):
            if visited[x] and visited[y] :
                left += graph[x][y]
            elif not visited[x] and not visited[y]:
                right += graph[x][y]
    res = min(res, abs(left-right))

def bt(depth):
    if depth == n:
        cal()
        return

    visited[depth] =True
    bt(depth+1)
    visited[depth] = False
    bt(depth+1)
bt(0)
print(res)
