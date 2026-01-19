package src.bfs.S16236;

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] map;
    static int sx, sy;
    static int sharkSize = 2;
    static int eatCount = 0;
    static int time = 0;

    // 상 좌 우 하 
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    static class Fish {
        int x, y, dist;
        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sx = i;
                    sy = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            Fish target = bfs();
            if (target == null) break;

            time += target.dist;
            sx = target.x;
            sy = target.y;
            map[sx][sy] = 0;

            eatCount++;
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(time);
    }

    static Fish bfs() {
        boolean[][] visited = new boolean[N][N];

        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        List<Fish> fishes = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int x = cur[0], y = cur[1], dist = cur[2];

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >=N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] > sharkSize) continue;

                visited[nx][ny] = true;
                q.offerLast(new int[]{nx, ny, dist + 1});

                if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
                    fishes.add(new Fish(nx, ny, dist + 1));
                }
            }
        }

        if (fishes.isEmpty()) return null;

        // fishes.sort((a, b) -> {
        //     if (a.dist != b.dist) return a.dist - b.dist;
        //     if (a.x != b.x) return a.x - b.x;
        //     return a.y - b.y;
        // });

        fishes.sort(
            Comparator.comparingInt((Fish f) -> f.dist)  // 1순위: 거리(dist) 오름차순
                .thenComparingInt(f -> f.x)        // 2순위: x좌표 오름차순
                .thenComparingInt(f -> f.y)        // 3순위: y좌표 오름차순
        );

        return fishes.get(0);
    }
}
