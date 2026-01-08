package src.dfs.S2667;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int count = 0;
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j] == 1) {
                    answer.add(dfs(i, j, N));
                    count++;
                }
            }
        }

        System.out.println(count);

        // 정렬
        answer.sort(Integer::compareTo);
        for (int next : answer) System.out.println(next);

        /*
        .length	  -> 배열 (Array) ex) int[] arr = new int[3]; arr.length;
        .length() -> 문자열 (String) ex)String s = "Hi"; s.length();
        .size()	  -> 컬렉션 (ArrayList 등) ex) List<Integer> l = new ArrayList<>(); l.size();

        배열은 한 번 정해지면 변하지 않는 '공간의 수'를 나타내는 속성이라서 괄호가 없는 .length를 쓴다. 
        문자열과 리스트는 클래스 내부에서 계산을 하거나 기능을 호출하는 것이기 때문에 메서드 형태인 ()가 붙는다고 이해하면 편하다.
        */
        // for (int i=0; i<answer.size(); i++) System.out.println(answer.get(i));
    }

    static int dfs(int x, int y, int N) {
        arr[x][y] = 0;
        int size = 1;

        for (int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (arr[nx][ny] == 1) {
                    size += dfs(nx, ny, N);
                }
            }
        }

        return size;
    }
}
