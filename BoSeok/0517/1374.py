import heapq
import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())

# 강의 시작 순서로 정렬
lst = sorted([list(map(int, sys.stdin.readline().split(" "))) for _ in range(n)], key=lambda x: x[1])

# 첫 강의
hq = []
heapq.heapify(hq)

count = 1
for i in range(n):
    if i != 0 :
        while hq:
            # 다음 강의 시작시간이 , 강의 하는 것 중에 가장 빨리 끝나느 시간보다 더 빠름
            # 방이 하나 더 필요
            if hq[0] > lst[i][1]:
                break
            else:
                heapq.heappop(hq)
    heapq.heappush(hq, lst[i][2])

    count = max(count, len(hq))

print(count)
