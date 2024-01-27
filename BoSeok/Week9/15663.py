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
            num = lst[i]
            visited[i] = True
            result.append(lst[i])
            bt()
            visited[i] = False
            result.pop()
bt()