package src.dfs.S1012;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());  // TestCase 
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 가로 
            int N = Integer.parseInt(st.nextToken()); // 세로
            int K = Integer.parseInt(st.nextToken()); // 배추 개수

            arr = new int[M][N];

            for (int i=0; i<K; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                arr[x][y] = 1;
            }

            int count = 0;

            for (int i=0; i<M; i++) {
                for (int j=0; j<N; j++) {
                    if (arr[i][j] == 1) {
                        dfs(i, j, M, N);
                        count ++;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }
    
    static void dfs(int x, int y, int M, int N) {
        arr[x][y] = 0; // 방문처리

        for (int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >=0 && nx < M && ny < N) {
                if (arr[nx][ny] == 1) {
                    dfs(nx, ny, M, N);
                }
            }
        }
    }
}
