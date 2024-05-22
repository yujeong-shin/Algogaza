import heapq
import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, m = map(int, sys.stdin.readline().split(" "))
k = int(input())

graph = [[] for _ in range(n + 1)]
dist = [1e9] * (n + 1)

for _ in range(m):
    u, v, w = map(int, sys.stdin.readline().split(" "))
    graph[u].append((v, w))
dist[k] = 0

heap = [(0, k)]
while heap:
    w, n = heapq.heappop(heap)
    for to_node, to_w in graph[n]:
        distance = w + to_w
        if distance < dist[to_node]:
            dist[to_node] = distance
            heapq.heappush(heap, (distance, to_node))
for i in dist[1:]:
    print(i if i != 1e9 else "INF")
