import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, m = map(int, sys.stdin.readline().split(" "))
lst = sorted(list(map(int, sys.stdin.readline().split(" "))))

visited = [False] * n
result = []

def bt():
    if len(result) == m:
        print(*result)
        return

    num = 0
    for i in range(n):
        if not visited[i] and num != lst[i]:
            if any(lst[i] < x for x in result):
                continue
            visited[i] = True
            num = lst[i]
            result.append(lst[i])
            bt()
            result.pop()
            visited[i] = False
bt()