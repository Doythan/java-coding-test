package src.dfs.S2468;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] area;
    static int[][] areaCopy;
    static int safeAreaMaxCount = 1;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        areaCopy = new int[N][N];
        int rainfall = 0;  // 강수량 
        
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] > rainfall) rainfall = area[i][j];
            }
        }
        rainfall -= 1;

        for (int i=rainfall; i>0; i--) {
            fillWater(i);
            int count = 0;
            for (int k=0; k<N; k++) {
                for (int l=0; l<N; l++) {
                    if (areaCopy[k][l] != -1) {
                        searchSafeArea(k, l);
                        count++;
                    }
                }
            }
            if (count > safeAreaMaxCount) safeAreaMaxCount = count;
        }
        System.out.println(safeAreaMaxCount);
    }

    static void fillWater(int h) {
        for (int i=0; i<N; i++) {
            areaCopy[i] = area[i].clone();
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (areaCopy[i][j] <= h) areaCopy[i][j] = -1;
            }
        }
    }

    static void searchSafeArea(int x, int y) {
        areaCopy[x][y] = -1;

        for (int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx < 0 || ny < 0 || nx >=N || ny >= N) continue;
            if (areaCopy[nx][ny] == -1) continue;
            searchSafeArea(nx, ny);
        }
    }
}
