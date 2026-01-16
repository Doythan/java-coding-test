package src.bfs.S10026;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] painting;
    static char[][] modifiedPainting;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        painting = new char[N][N];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<N; j++) {
                painting[i][j] = line.charAt(j);
            }
        }

        int firstAnwser = 0;
        int secondAnwser = 0;

        visited = new boolean[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    zoneCount(i, j);
                    firstAnwser++;
                }
            }
        }

        modifyPainting();
        
        visited = new boolean[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    zoneCountTwo(i, j);
                    secondAnwser++;
                }
            }
        }

        System.out.println(firstAnwser + " " + secondAnwser);
    }

    // 그림 -> 적록색약 그림
    static void modifyPainting() {
        for (int i=0; i<N; i++) {
            modifiedPainting = painting.clone();
            for (int j=0; j<N; j++) {
                if (modifiedPainting[i][j] == 'R') {
                    modifiedPainting[i][j] = 'G';
                }
            }
        }
    }

    // 구역 카운트 (정상인)
    static void zoneCount(int i, int j) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        char color = painting[i][j];

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                if (painting[nx][ny] == color) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    // 구역 카운트 (적록색약)
    static void zoneCountTwo(int i, int j) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        char color = modifiedPainting[i][j];

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                if (modifiedPainting[nx][ny] == color) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
