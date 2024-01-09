import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

lst = list(map(int, sys.stdin.readline().split(" ")))

res = []
count = 0


def bt(depth):
    global count
    # 10개 다 채웠으면
    if depth == 10:
        # 두 개 함수 겹치는거 찾음
        same = len([i for i, j in zip(res, lst) if i == j])
        # 5개 넘어가면
        if same >= 5:
            # 경우의 수 1개 증가
            count += 1
        return

    for i in range(1, 6):
        # 크기 1  이상이고, 3개가 연속이면 지나침
        if depth > 1 and res[depth - 2] == res[depth - 1] == i:
            continue
        # 아니면 넣어주고
        res.append(i)
        # 다음꺼 호출해주고
        bt(depth + 1)
        # 끝 찍고 백트래킹
        res.pop()


bt(0)
print(count)
