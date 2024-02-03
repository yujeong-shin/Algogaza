import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())
lst = [list(map(int, sys.stdin.readline().split(" "))) for _ in range(n)]

for i in lst:
    rank = 1
    for j in lst:
        if i[0] < j[0] and i[1] < j[1]:
            rank += 1
    print(rank, end=" ")
