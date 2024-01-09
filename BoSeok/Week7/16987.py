import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())
lst = [list(map(int,sys.stdin.readline().split(" "))) for _ in range(n)]
res = 0
def bt(x):
    global res
    if x == n:
        temp =0
        for eggs in lst:
            if eggs[0] <= 0:
                temp += 1
        res = max(temp,res)
        return

    # 지금 들고 있는계란 깨짐
    if lst[x][0] <= 0:
        bt(x+1)
    # 안 깨짐
    else:
        eggFlag= False
        for i in range(len(lst)):
            # 자기 자신이거나 이미 깨져있으면 패스
            if i == x or lst[i][0] <= 0: continue
            # 부쉬기
            eggFlag = True

            lst[x][0] -= lst[i][1]
            lst[i][0] -= lst[x][1]
            # 다음꺼 호출
            bt(x+1)
            lst[x][0] += lst[i][1]
            lst[i][0] += lst[x][1]
        # 부실게 없으면 다음꺼 들기
        if eggFlag == False:
            bt(x+1)
bt(0)
print(res)



