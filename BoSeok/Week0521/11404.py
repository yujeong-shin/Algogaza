import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')
n = int(input())
m = int(input())

graph = [[1e9] * (n) for _ in range(n)]
for i in range(n):
    graph[i][i] = 0

for _ in range(m):
    u, v, e = map(int, sys.stdin.readline().split(" "))
    graph[u - 1][v - 1] = min(graph[u - 1][v - 1], e)

for k in range(n):
    for x in range(n):
        for y in range(n):
            if graph[x][y] >= graph[x][k] + graph[k][y]:
                graph[x][y] = graph[x][k] + graph[k][y]

for a in range(n):
    for b in range(n ):
        if graph[a][b] == 1e9:
            print("0",  end=" ")
        else:
            print(graph[a][b], end=" ")
    print()
