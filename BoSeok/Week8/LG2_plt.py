import matplotlib.pyplot as plt

graph = [[0] * 10 for _ in range(10)]

rows = len(graph)
cols = len(graph[0])

# 직사각형 만들기
for i in range(len(graph)):
    for j in range(len(graph[0])):
        if i == 0 or i == rows - 1 or j == 0 or j == cols - 1:
            graph[i][j] = 1
            plt.scatter(i, j)

plt.show()
# (2,3) 점 뒀을때
for i in range(len(graph)):
    for j in range(len(graph[0])):
        if i == 2 or j == 3:
            plt.scatter(i,j)
plt.show()
# (6,6) 뒀을경우
for i in range(len(graph)):
    for j in range(len(graph[0])):
        if i == 6 or j == 6:
            plt.scatter(i,j)
plt.show()

for i in range(len(graph)):
    for j in range(len(graph[0])):
        if i == 2 or j == 3:
            plt.scatter(i,j)
for i in range(len(graph)):
    for j in range(len(graph[0])):
        if i == 6 or j == 6:
            plt.scatter(i,j)
plt.show()