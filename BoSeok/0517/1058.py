import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())
graph = [list(input()) for _ in range(n)]

friends = [[0] * n for _ in range(n)]

for k in range(n):
    for x in range(n):
        for y in range(n):
            if x != y:
                if graph[x][y] == "Y" or (graph[x][k] == "Y" and graph[k][y] == "Y"):
                    friends[x][y] = 1


print(max([sum(i) for i in friends]))

# 두 사람이 친구이거나, A와 친구이고, B와 친구인 C