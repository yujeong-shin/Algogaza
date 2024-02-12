import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')
n, m, b = map(int, sys.stdin.readline().split(" "))
graph = [list(map(int, sys.stdin.readline().split(" "))) for _ in range(n)]
res = 1e9
h = 0
for height in range(257):
    maxx, minn = 0, 0
    for x in range(n):
        for y in range(m):
            # 높으면 깎아야함
            if graph[x][y] >= height:
                maxx += graph[x][y] - height
            # 낮으면 올려야함
            else:
                minn += height - graph[x][y]

    # 깎을 수 있는 조건
    if maxx + b >= minn:
        if minn + (maxx * 2) <= res:
            res = minn + (maxx * 2)
            h = height
print(res, h)