import sys
from itertools import combinations

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

T = int(input())

for _ in range(T):
    res = 1e9
    N = int(input())
    lst = list(map(str, sys.stdin.readline().rstrip().split(" ")))

    if N >= 33:
        print(0)
    else:
        for comb in list(combinations(lst, 3)):
            score = 0
            for r in range(4):
                if comb[0][r] != comb[1][r]:
                    score += 1
                if comb[0][r] != comb[2][r]:
                    score += 1
                if comb[1][r] != comb[2][r]:
                    score += 1
            res = min(score, res)
        print(res)