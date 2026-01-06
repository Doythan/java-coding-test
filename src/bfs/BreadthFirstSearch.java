package src.bfs;

import java.util.*;

public class BreadthFirstSearch {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int n = 5; // 정점(노드) 개수
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i=1; i<n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 추가 (무방향)
        graph[1].add(2);
        graph[2].add(1);

        graph[1].add(3);
        graph[3].add(1);

        graph[2].add(4);
        graph[4].add(2);

        graph[3].add(5);
        graph[5].add(3);

        System.out.println(Arrays.deepToString(graph));

        bfs(1);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");

            for (int next : graph[cur]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
