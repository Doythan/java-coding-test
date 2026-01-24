package src.dfs.S2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n; // 전체 사람의 수
    static int p1, p2; // 촌수를 계산해야하는 사람 2명
    static int m; // 부모 자식가읜 관계의 수
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer = -1;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        int x, y;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        searchNumber(p1, 0);
        System.out.println(answer);
    }

    static void searchNumber(int current, int depth) {
        visited[current] = true;

        if (current == p2) {
            answer = depth;
            return;
        }

        for (int next : graph[current]) {
            if (!visited[next]) {
                searchNumber(next, depth + 1);
            }
        }
    }
}
