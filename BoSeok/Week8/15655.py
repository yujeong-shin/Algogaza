import sys
from itertools import combinations

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, k = map(int,input().split())
for i in list(combinations(sorted(list(map(int,sys.stdin.readline().split(" ")))),k)):
    print(*i)