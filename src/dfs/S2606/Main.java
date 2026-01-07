package src.dfs.S2606;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static Integer cnt = 0;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        graph = new ArrayList[node+1];
        visited = new boolean[node+1];

        for (int i=1; i<node+1; i++) graph[i] = new ArrayList<>();

        for (int i=1; i<edge+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        dfs(1);
        System.out.println(cnt-1);
    }

    static void dfs(int node) {
        visited[node] = true;
        cnt++;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
