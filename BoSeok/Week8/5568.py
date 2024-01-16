import sys
from itertools import permutations

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())
k = int(input())

sets = set()
for i in list(permutations([str(input()) for _ in range(n)], k)) :
    sets.add("".join(i))
print(len(sets))