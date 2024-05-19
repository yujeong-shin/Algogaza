import heapq
import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())
if n == 1:
    print(0)
    exit()
heap = []
heapq.heapify(heap)

for i in enumerate([int(input()) for _ in range(n)], start=1):
    heapq.heappush(heap, (-i[1], i[0]))

count = 0
while True:
    vote, candidate = heapq.heappop(heap)
    if candidate == 1:
        max_v, max_c = heapq.heappop(heap)
        if max_v == vote:
            count += 1
            print(count)
            exit()
        else:
            break
    else:
        vote += 1
        count += 1
        heapq.heappush(heap, (vote, candidate))
        temp = []
        while heap:
            x, y = heapq.heappop(heap)
            if y == 1:
                x -= 1
            temp.append((x, y))
        heapq.heapify(temp)
        heap = temp
print(count)
