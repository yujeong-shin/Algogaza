// 백준 1260번
// 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
// 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Q1260 {

    // static 변수 생성 
    // 노드 표현을 위한 2차원 배열 treeArray, 노드에 방문했는지 확인을 위한 visited
    static int[][] treeArray;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        
        // 문제에서 주어지는 입력값 (정점의 개수: N, 간선의 개수: M, 탐색을 시작할 정점의 번호: V)
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 정점개수: N
        int M = sc.nextInt();   // 간선개수: M
        int V = sc.nextInt();   // 시작정점번호: V 

        // 정점 개수에 맞춰 동적할당
        treeArray = new int[N+1][N+1];


        // 간선이 연결하는 두 정점의 번호 입력 (연결됨 = 1)
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 연결된 노드를 1로 세팅
            treeArray[a][b] = 1;
            treeArray[b][a] = 1;
        }

        // node가 1부터 시작하기 때문에 N + 1
        visited = new boolean[N + 1];
        dfs(V);

        System.out.println();

        visited = new boolean[N + 1];

        bfs(V);

        System.out.println();
    }


    // DFS(깊이 우선 탐색) 구현 코드
    // DFS란? 
    // 루트 노드(혹은 다른 임의의 노드)에서 시작해서 다음 분기(branch)로 넘어가기 전에 해당 분기를 완벽하게 탐색하는 방법

    // 깊이 우선 탐색(DFS)의 특징
    // 자기 자신을 호출하는 순환 알고리즘의 형태 를 가지고 있다.
    // 전위 순회(Pre-Order Traversals)를 포함한 다른 형태의 트리 순회는 모두 DFS의 한 종류이다.
    // 이 알고리즘을 구현할 때 가장 큰 차이점은, 그래프 탐색의 경우 어떤 노드를 방문했었는지 여부를 반드시 검사 해야 한다는 것이다.
    // 이를 검사하지 않을 경우 무한루프에 빠질 위험이 있다.
    
    // DFS 구현 방법
    // 구현 방법 2가지
        // 1. 순환 호출 이용
        // 2. 명시적인 스택 사용
    private static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        if(v == treeArray.length) return;

        for(int j = 1; j < treeArray.length; j++) {
        	// 연결된 노드인데 방문하지 않은 경우 
            if(treeArray[v][j] == 1 && visited[j] == false) {
            	// 연결된 노드 찾으면 재귀함수 호출
                dfs(j);
            }
        }
    }


    // BFS(너비 우선 탑색) 구현 코드
    // BFS란?
    // 루트 노드(혹은 다른 임의의 노드)에서 시작해서 인접한 노드를 먼저 탐색하는 방법

    // 너비 우선 탐색(BFS)의 특징
    // 자료구조 Queue를 이용하는게 포인트
    // BFS는 방문한 노드들을 차례로 저장한 후 꺼낼 수 있는 자료 구조인 큐(Queue)를 사용한다.
    // -> 선입선출(FIFO) 원칙으로 탐색
    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        // Queue.offer -> 값을 추가하는데 Queue에 데이터가 가득 찼을 시 false 반환
        queue.offer(v);
        visited[v] = true;

        System.out.print(v + " ");

        while(!queue.isEmpty()) {
            // Queue.poll -> FIFO로 값을 반환받는데 Queue가 비어있을 경우 NULL 반환
            int n = queue.poll();

			// 노드 하나로 연결된 노드 먼저 다 체크 
            for(int i = 1; i < treeArray.length; i++) {
           		 // 연결된 노드인데 방문하지 않은 경우 
                if(treeArray[n][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    queue.offer(i);
                }
            }
        }   
    }
}