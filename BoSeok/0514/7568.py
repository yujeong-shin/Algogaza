import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

lst = [list(map(int, sys.stdin.readline().split(" "))) for _ in range(int(input()))]
print(' '.join(str(1 + sum(i[0] < j[0] and i[1] < j[1] for j in lst)) for i in lst))

# 현재 사람 i보다 키 몸무게 둘다 큰사람 찾기