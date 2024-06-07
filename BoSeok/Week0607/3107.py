import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

word = input().split(":")
res = []
check_continuity = False
for i in word:
    if i == "" and not check_continuity:
        res += ['0000' for _ in range(8-len(word)+1)]
        check_continuity = True
    else:
        res.append(i.zfill(4))
print(":".join(res))

