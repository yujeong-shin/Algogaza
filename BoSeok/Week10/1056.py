import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())
count = 0
for i in range(1,n+1):
    if i < 100:
        count += 1

    else:
        new_n = list(map(int,str(i)))
        if new_n[2]-new_n[1] == new_n[1]-new_n[0]:
            count +=1
print(count)

