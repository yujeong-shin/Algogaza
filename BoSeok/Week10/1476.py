import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

E, S, M = map(int, sys.stdin.readline().split(" "))

Year = 1
while True:
    if (Year - E) % 15 == 0 and (Year - S) % 28 ==0  and (Year - M) % 19 == 0:
        break
    Year += 1
print(Year)
