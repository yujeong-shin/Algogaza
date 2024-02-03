import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')
n = int(input())
start = 666
while True:
    if "666" in str(start):
        n -= 1
        if n == 0:
            break
    start += 1
print(start)