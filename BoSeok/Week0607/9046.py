import sys
from collections import defaultdict, Counter

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

n = int(input())
lst = [str(input()) for i in range(n)]
res = defaultdict(int)
for i in lst:
    i = i.replace(" ", "")
    CM = Counter(i).most_common()
    try:
        if CM[0][1] == CM[1][1]:
            print("?")
        else:
            print(CM[0][0])
    except:
        print(CM[0][0])
