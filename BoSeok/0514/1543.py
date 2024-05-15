import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')
word = input().rstrip(); temp = input().rstrip()
count = start = 0

while (start := word.find(temp, start)) != -1:
    count += 1
    start += len(temp)
print(count)
