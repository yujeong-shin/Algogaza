import sys
from itertools import permutations, product

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, m = map(int, sys.stdin.readline().split(" "))
lst = sorted(list(map(int,sys.stdin.readline().split(" "))))
result = []
visited = [False] * n
def bt():
    if m == len(result):
        print(*result)
        return
    num = 0
    for i in range(n):
        if not visited[i] and num != lst[i]:
            if any(lst[i] < x for x in result):
                continue
            result.append(lst[i])
            num = lst[i]
            bt()
            result.pop()

bt()