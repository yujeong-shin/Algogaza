import sys
from itertools import combinations

combi = list(combinations(range(6), 2))  # 15경기 하는 경우의수
res = []


def bt(depth):
    # static변수
    global count

    # 15경기 다했을때
    if depth == 15:
        # 가능하다고 설정
        count = 1
        # 결과 값 돌면서
        for x in result:
            # 승무패 합이 0 이 아니면
            if x.count(0) != 3:
                # 불가능하다고 리턴
                count = 0
                return count
        return

    leftTeam, rightTeam = combi[depth]  # 경기

    # 각 경기마다 승 무 패 백트래킹
    # [0,2] > leftteam 승리 ,rightteam패배 다른거 동일
    for g_result1, g_result2 in [(0, 2), (1, 1), (2, 0)]:
        if result[leftTeam][g_result1] > 0 and result[rightTeam][g_result2] > 0:
            result[leftTeam][g_result1] -= 1
            result[rightTeam][g_result2] -= 1
            bt(depth+1)
            result[leftTeam][g_result1] += 1
            result[rightTeam][g_result2] += 1

for i in range(4):
    game = list(map(int, sys.stdin.readline().split(" ")))

    # 3 개씩 잘라서 저장
    result = [game[i:i + 3] for i in range(0, 16, 3)]
    # 실패한다고 가정
    count = 0
    bt(0)
    res.append(count)
print(*res)