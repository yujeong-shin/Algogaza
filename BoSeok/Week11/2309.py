import sys
from itertools import combinations

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

lst = list(combinations(sorted([int(input()) for _ in range(9)]),7))
for i in lst:
    if sum(i) == 100:
        print(*i,sep="\n")
