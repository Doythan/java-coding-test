package src.dfs.S4963;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, 1, -1, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());  
            int h = Integer.parseInt(st.nextToken());
            arr = new int[h][w];

            if (w == 0 && h == 0) return;

            for (int i=0; i<h; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int j=0; j<w; j++) {
                    arr[i][j] = Integer.parseInt(st2.nextToken());
                }
            }

            int count = 0;

            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (arr[i][j] == 1) {
                        dfs(i, j, w, h);
                        count ++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int x, int y, int w, int h) {
        arr[x][y] = 0;

        for (int d=0; d<8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < h && ny >=0 && ny < w) {
                if (arr[nx][ny] == 1) {
                    dfs(nx, ny, w, h);
                }
            }
        }
    }
}
