import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

c, r = map(int,sys.stdin.readline().split())
k = int(input())
if k > c*r:
    print(0)
    exit()
graph = [[0] * c for _ in range(r)]


