import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')
sys.setrecursionlimit(10**6)
n, m = map(int, sys.stdin.readline().split(" "))

parents = [i for i in range(n + 1)]

def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])
    return parents[x]


def union(x, y):
    find_x = find(x)
    find_y = find(y)

    if find_x > find_y:
        parents[find_x] = find_y
    else:
        parents[find_y] = find_x


for _ in range(m):
    num, a, b = map(int, sys.stdin.readline().split(" "))
    if num == 1:
        if find(a) == find(b):
            print("YES")
        else:
            print("NO")
    else:
        union(a, b)
