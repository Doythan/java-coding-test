# 유기농 배추

``` java
import java.io.*;
import java.util.*;

public class Main {
    static int M;  // 가로
    static int N;  // 세로
    static int K;  // 배추 개수
    static int earthWorm = 0;  // 지렁이 개수 
    static int[][] field;  // 배추 밭 

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());  // TestCase 
        
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            field = new int[N][M];

            for (int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }

            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (field[i][j] == 1) {
                        searchCabbage(i, j);
                        earthWorm++;
                    }
                }
            }
            sb.append(earthWorm).append("\n");
            earthWorm = 0;
        }
        System.out.println(sb);
    }

    static void searchCabbage(int x, int y) {
        // 방문 처리 
        field[x][y] = 0;

        // 조건 확인
        for (int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (field[nx][ny] == 1) searchCabbage(nx, ny);
        }
    }
}

```