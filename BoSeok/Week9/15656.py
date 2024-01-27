import sys
from itertools import product

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, m =map(int,sys.stdin.readline().split(" "))
lst = sorted(list(map(int,sys.stdin.readline().split(" "))))

for i in list(product(lst,repeat = m)):
    print(*i)
test