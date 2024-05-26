import sys
from collections import defaultdict

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, m = map(int, sys.stdin.readline().split(" "))

x = defaultdict(str)

for i in range(n):
    id, password = map(str, sys.stdin.readline().rstrip().split(" "))
    x[id] = password

print(*[x[input()] for i in range(m)], sep='\n')
