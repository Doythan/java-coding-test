package src.dfs;

import java.util.*;

public class DepthFirstSearch {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int n = 5; // 정점 개수
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i=1; i<=n; i++) {
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

        dfs(2);
    }

    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
