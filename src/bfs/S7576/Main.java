package src.bfs.S7576;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] storage;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        storage = new int[N][M];

        for (int i=0; i<N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                storage[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        bfs(N, M);
        
        int answer = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (storage[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, storage[i][j]);
            }
        }
        System.out.println(answer-1);
    }

    static void bfs(int N, int M) {
        Deque<int[]> queue = new ArrayDeque<>();

        // 모든 익은 토마토를 시작점으로
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (storage[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (storage[nx][ny] == 0) {
                        storage[nx][ny] = storage[x][y] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
