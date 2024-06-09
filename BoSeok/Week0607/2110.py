import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, c =map(int,sys.stdin.readline().split(" "))
lst = sorted([int(sys.stdin.readline().rstrip()) for _ in range(n)])

start = 1
end = lst[-1] - lst[0]
result = 0

#  첫 집은 설치를 해줘야 무조건 최댓값 나옴
while start <= end:
    now = lst[0]
    count = 1
    middle = (start + end) // 2
    for i in range(1,n):
        if lst[i] - now >= middle:
            count += 1
            now = lst[i]
    if count >= c:
        if result < middle:
            result = middle
        start = middle +1
    else:
        end = middle - 1

print(result)

