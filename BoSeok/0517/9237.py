import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

N = int(input())
lst = sorted(list(map(int, sys.stdin.readline().split(" "))), reverse=True)
idx = 0
for i in range(len(lst), 0, -1):
    lst[idx] -= i
    idx += 1
print(max(lst) + idx + 2)
