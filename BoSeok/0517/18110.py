import sys
from _collections import deque

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')
N = int(input())
def my_round(val):
    return int(val) + 1 if val - int(val) >= 0.5 else int(val)

if N == 0 :
    print(0)
    exit()
lst = deque(sorted([int(input()) for _ in range(N)]))

length = my_round(len(lst) * 0.15)
for i in range(length):
    lst.pop()
    lst.popleft()
print(my_round(sum(lst) / len(lst)))


