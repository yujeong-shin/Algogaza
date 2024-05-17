import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')
N = int(input())
M = int(input())
word = input()

left, right ,answer = 0, 0 , 0

while right < M:
    if word[right:right + 3] == 'IOI':
        right += 2
        if right - left == 2 * N:
            answer += 1
            left += 2
    else:
        left = right = right + 1

print(answer)