import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, m =map(int,sys.stdin.readline().split(" "))
lst = sorted(list(map(int,sys.stdin.readline().split(" "))))

result = []

def bt(num):
    if m == len(result):
        print(*result)
        return
    for i in range(n):
        if any(lst[i] < x for x in result):
            continue
        result.append(lst[i])
        bt(num+1)
        result.pop()
bt(0)
