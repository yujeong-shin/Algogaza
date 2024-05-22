import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

l, r = input().split()
count = 0
if len(l) == len(r):
    for left, right in zip(l, r):
        if left == right == "8":
            count += 1
        elif left != right:
            break
print(count)
