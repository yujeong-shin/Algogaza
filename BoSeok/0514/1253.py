import sys
from itertools import combinations

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())
lst = sorted(list(map(int, sys.stdin.readline().split(" "))))
res = 0
for i in range(len(lst)):
    target = lst[i]
    start = 0
    end = n - 1
    while start < end:
        sum = lst[start] + lst[end]
        if sum == target:
            if start != i and end != i:
                res += 1
                break
            elif i == start:
                start += 1
            elif i == end:
                end -= 1
        elif sum < target:
            start += 1
        else:
            end -= 1
print(res)
