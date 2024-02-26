import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, kim, lim = map(int,input().split(" "))
count = 0

while kim != lim:
    kim -= kim//2
    lim -= lim//2
    count += 1
print(count)