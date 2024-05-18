import heapq
import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, m, k, x = map(int, sys.stdin.readline().split(" "))

graph = [[] for _ in range(n + 1)]

for i in range(m):
    a, b = map(int, sys.stdin.readline().split(" "))
    # a 좌표에서 b좌표로 모든 가중치는 1이다.
    graph[a].append((b, 1))

# 첫 거리는 모두 최댓값으로 선언
dist = [1e9] * (n + 1)

# 가중치, 시작좌표 (문제에서 x라함)
hq = [(0, x)]
heapq.heapify(hq)

while hq:
    # 현재 가중치, 현재 노드
    cur_w, cur_node = heapq.heappop(hq)
    if dist[cur_node] < cur_w:
        continue
    # 현재 노드랑 연결된거 가져옴
    for next_node, next_w in graph[cur_node]:
        # 거리를 계산해봄
        d = cur_w + next_w
        # 더 짧고 , 1로 돌아오는게 아니면
        if d < dist[next_node] and next_node != 1:
            # 다음 노드로 가는 길 중에 가장 짧다고 판단.
            dist[next_node] = d
            # 다음 노드의 그 다음노드를 찾기위해 hq에 넣음
            heapq.heappush(hq, (d, next_node))

flag = False
for i in range(1, n + 1):
    if dist[i] == k:
        flag = True
        print(i)
if not flag:
    print(-1)
