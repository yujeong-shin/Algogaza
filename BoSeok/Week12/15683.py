import copy
import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n, m = map(int, sys.stdin.readline().split(" "))
graph = [list(map(int, sys.stdin.readline().split(" "))) for _ in range(n)]

move = [(-1, 0), (1, 0), (0, -1), (0, 1)]
move_direction = [
    [],
    [[0], [1], [2], [3]],  # 1
    [[0, 1], [2, 3]],  # 2
    [[0, 2], [0, 3], [1, 2], [1, 3]],  # 3
    [[0, 1, 2], [0, 1, 3], [0, 2, 3], [1, 2, 3]],  # 4
    [[0, 1, 2, 3]]  # 5
]
cctv = []
for x in range(n):
    for y in range(m):
        if graph[x][y] != 0 and graph[x][y] != 6:
            cctv.append((graph[x][y], x, y))


def check(graph, direction, x, y):
    # 진행 방향
    for dir in direction:
        nx, ny = x, y
        while True:
            nx += move[dir][0]
            ny += move[dir][1]
            if 0 <= nx < n and 0 <= ny < m:
                if graph[nx][ny] == 6:
                    break
                elif graph[nx][ny] == 0:
                    graph[nx][ny] = "x"
            else:
                break
def dfs(depth, graph):
    global res
    if depth == len(cctv):  # cctv 다 채우면
        res = min(res, sum(graph[i].count(0) for i in range(n)))  # 0 의 갯수 합 최솟값 으로 만듦
        return
    graph_copy = copy.deepcopy(graph)  # 복사 해놓기
    cctv_num, x, y = cctv[depth]  # 탐색 cctv
    # cctv_num = [[j for j in graph[i]] for i in range(n)] // deepcopy랑 같음.
    for i in move_direction[cctv_num]:  # 방향 다 체크해야함
        check(graph_copy, i, x, y)  # cctv방향별로 다 체크해보기, (cctv, 방향, x좌표, Y좌표)
        dfs(depth + 1, graph_copy)
        graph_copy = copy.deepcopy(graph)  # 돌려놓기,


res = 1e9
dfs(0, graph)
print(res)
