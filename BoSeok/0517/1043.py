import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, m = map(int, input().split())
x = list(map(int, input().split()))

# 부모 일단 자기 자신
parents = [i for i in range(n + 1)]

# 거짓말하면 안되는곳 0 으로 해줌
for i in x[1:]:
    parents[i] = 0

lst = [list(map(int, sys.stdin.readline().split(" "))) for _ in range(m)]


def find(x):
    # 자기자신이 아니면 부모가 존재
    if parents[x] != x:
        # 부모 찾으러 출발
        parents[x] = find(parents[x])
    return parents[x]

# 합침
def union(x, y):
    # 부모들 찾아서
    x = find(x)
    y = find(y)
    # 작은 값으로 바꿔줌
    if x < y:
        parents[y] = x
    else:
        parents[x] = y

# 파티들 하나씩 다 돌면서 union 해줌.
for i in range(m):
    people = lst[i][1:]
    for j in range(lst[i][0] - 1):
        union(people[j], people[j + 1])

# 파티들 싹 돌면서 진실 알고있는애 있는지 획인
ans = 0
for party in lst:
    for i in party[1:]:
        if find(parents[i]) == 0:
            break
    else:
        ans += 1
print(ans)
