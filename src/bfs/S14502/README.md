# 연구소

## 코드
``` java
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] tempMap;
    static int answer = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWall(0);
        System.out.println(answer);
    }

    // 벽 3개 세우기 (완탐)
    static void buildWall(int cnt) {
        if (cnt == 3) {
            copyMap();
            spreadVirus();
            countSafeArea();
            return;
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // map -> tempMap 복사하기
    static void copyMap() {
        tempMap = new int[N][M];
        for (int i=0; i<N; i++) {
            tempMap[i] = map[i].clone();
        }
    }

    // 바이러스 확산 (BFS)
    static void spreadVirus() {
        Deque<int[]> q = new ArrayDeque<>();

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (tempMap[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (tempMap[nx][ny] == 0) {
                    tempMap[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    // 안전 영역 계산
    static void countSafeArea() {
        int safe = 0;
        for (int i=0; i<N; i++) {
            for (int j=0 ;j<M; j++) {
                if (tempMap[i][j] == 0) safe++;
            }
        }
        answer = Math.max(answer, safe);
    }
}
```

## 메모
1. 벽세우기
2. 맵 복사
3. 바이러스 뿌리기
4. 안전한 영역 계산