import sys
from itertools import permutations, product

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, m = map(int, sys.stdin.readline().split(" "))

for i in product(sorted(list(set(list(map(int, sys.stdin.readline().split(" ")))))), repeat=m):
    print(*i)
