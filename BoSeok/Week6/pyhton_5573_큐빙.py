import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

t = int(input())
up = [["w"] * 3 for _ in range(3)]
down = [["y"] * 3 for _ in range(3)]
left = [["g"] * 3 for _ in range(3)]
right = [["b"] * 3 for _ in range(3)]
front = [["r"] * 3 for _ in range(3)]
back = [["o"] * 3 for _ in range(3)]
print(up)
for _ in range(t):
    case = int(input())
    lst = sys.stdin.readline().rstrip().split(" ")
    for order in lst:
        if order[0] == "L":
            if order[1] == "+":
                left[0][0], left[0][1],left[0][2],left[1][0],left[1][1],left[1][2],left[2][0],left[2][1],left[2][2] = left[2][0],left[1][0],left[0][0],left[2][1],left[1][1],left[0][1],left[2][2],left[1][2],left[0][2]
                up[2][0], up[2][1], up[2][2], front[0][0], front[1][0], front[2][0], down[0][0], down[0][1], down[0][1],back[0][2], back[1][2], back[2][2] = \
                    back[2][2], back[1][2], back[0][2], up[2][2], up[2][1], up[2][0], front[2][0], front[2][1], front[2][2],down[0][0], down[0][1], down[0][2]
            if order[1] == "-": # + 를 세번 한 것과 같음
                pass

    #     그 외 11개 다 해주기
    break

for x in range(3):
    for y in range(2,-1,-1):
        print(up[y][x],end="")
    print()

# 2,0/ 1,0,/ 0,0
# 2,1 1.1/ 0,1