import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

t = int(input())


def bt(player, point):
    global res
    # 11명 다 채움
    if player == 11:
        res = max(res, point)

    for i in range(11):
        # 이미 포지션 선정완료 했거나, 점수가 0점이라 선택 할 수 없음
        if visited[i] or not player_points[player][i]:
            continue

        # 방문처리
        visited[i] = 1
        # 다음 포지션 찾으러
        bt(player + 1, point + player_points[player][i])
        # 다 찍고 돌아옴 다음거 체크해야함
        visited[i] = 0


for i in range(t):
    res = 0

    # 선수들 포지션포인트
    player_points = [list(map(int, sys.stdin.readline().split(" "))) for _ in range(11)]

    # 선수 선택했는지 체크
    visited = [False] * 11
    bt(0, 0)
    print(res)
