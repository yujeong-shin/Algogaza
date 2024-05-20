import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n,m = map(int,sys.stdin.readline().rstrip().split())
graph = [[1e9] * (n+1) for _ in range(n+1)]

for i in range(m):
    a, b = map(int,sys.stdin.readline().split())
    graph[a][b] = 1

for k in range(1,n+1):
    for x in range(1,n+1):
        for y in range(1,n+1):
            if graph[x][y]> graph[x][k] + graph[k][y]:
                graph[x][y] =  graph[x][k] + graph[k][y]
count = 0
# 각 노드에 대해 다른 모든 노드로 도달할 수 있는지 체크
for i in range(1, n + 1):
    cnt = sum(1 for j in range(1, n + 1) if graph[i][j] != 1e9 or graph[j][i] != 1e9)
    if cnt == n-1:
        count += 1

print(count)