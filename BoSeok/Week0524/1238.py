import heapq
import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

N, M, X = map(int, sys.stdin.readline().split(" "))

graph = [[] for _ in range(N + 1)]
for _ in range(M):
    u, v, e = map(int, input().split())
    graph[u].append([v, e])

def solution(X):
    dist = [1e9] * (N + 1)
    hq = []
    heapq.heappush(hq, (0, X))
    dist[X] = 0

    while hq:
        cur_w, cur_node = heapq.heappop(hq)

        if dist[cur_node] < cur_w:
            continue

        for next_node, next_w in graph[cur_node]:
            d = cur_w + next_w
            if dist[next_node] > d:
                dist[next_node] = d
                heapq.heappush(hq, (d, next_node))

    return dist

return_res = solution(X)
return_res[0] = 0
for i in range(1, N+1):
    if i != X:
        res = solution(i)
        return_res[i] += res[X]
print(max(return_res))