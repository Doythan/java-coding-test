package src.bfs;

import java.util.*;

public class BreadthFirstSearchTwo {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int n = 5;
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[1].addAll(Arrays.asList(2, 3));
        graph[2].addAll(Arrays.asList(1, 4));
        graph[3].addAll(Arrays.asList(1, 5));
        graph[4].add(2);
        graph[5].add(3);

        System.out.println("BFS 탐색 순서:");
        bfs(1);
    }

    static void bfs(int start) {
        // LinkedList 대신 ArrayDeque 사용 (코테 권장사항)
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}