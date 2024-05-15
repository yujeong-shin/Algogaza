import sys

sys.stdin = open('/Users/song/Desktop/Python/Python/h.txt', 'r')

print('\n'.join(' '.join(x) for x in
                sorted([sys.stdin.readline().rstrip().split() for _ in range(int(input()))], key=lambda x: int(x[0]))))
