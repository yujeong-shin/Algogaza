import sys
from itertools import permutations

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

for i in list(permutations([i for i in range(1,int(input())+1)])):
    print(*i)