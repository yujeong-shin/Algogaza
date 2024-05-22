import heapq
import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())
m = int(input())

# graph 생성
graph = [[] for _ in range(n + 1)]

# 거리 최댓값
dist = [1e9] * (n + 1)

# 버스 그래프에 넣기
for _ in range(m):
    u, v, w = map(int, sys.stdin.readline().split(" "))
    graph[u].append((v, w))

start, end = map(int, sys.stdin.readline().split())
# 시작위치와 가중치
hq = [(start, 0)]
while hq:
    # 현재 위치와 가중치
    w, n = heapq.heappop(hq)
    # 기존 최단거리보다 멀면 굳이 안 가도 됨
    if dist[w] < n:
        continue
    # 다음 노드들 확인함
    for to_node, to_w in graph[w]:
        # 지금까지의 가중치와 다음 노드를 밟았을때 가중치를 더해줌
        distance = n + to_w
        # 그것이 최솟값이면, (이미 다른 누군가가 들렸거나, 1e9이거나)
        if distance < dist[to_node]:
            # 바꿔
            dist[to_node] = distance
            # 넣어
            heapq.heappush(hq,(to_node,distance))
print(dist[end])