import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, m = map(int, sys.stdin.readline().rstrip().split(" "))

graph = [[1e9] * n for _ in range(n)]
for i in range(m):
    x, y = map(int, sys.stdin.readline().split(" "))
    graph[x - 1][y - 1] = 1
    graph[y - 1][x - 1] = 1

for i in range(n):
    graph[i][i] = 0

for k in range(n):
    for x in range(n):
        for y in range(n):
            graph[x][y] = min(graph[x][y], graph[x][k] + graph[k][y])
res = 1e9
result = 0
for i in range(n):
    temp = sum(graph[i])

    if temp < res:
        res = temp
        result = i+1
print(result)