# 안전 영역

``` java
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, area[i][j]);
            }
        }

        int maxSafeAreas = 1; // 비가 안 올 경우 최소 1개

        // 높이 1부터 maxHeight-1까지 확인 (maxHeight 이상은 모두 잠기므로 의미 없음)
        for (int h = 1; h < maxHeight; h++) {
            visited = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 물에 잠기지 않고 방문하지 않은 곳 탐색
                    if (area[i][j] > h && !visited[i][j]) {
                        bfs(i, j, h);
                        count++;
                    }
                }
            }
            maxSafeAreas = Math.max(maxSafeAreas, count);
        }
        System.out.println(maxSafeAreas);
    }

    static void bfs(int x, int y, int h) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (!visited[nx][ny] && area[nx][ny] > h) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
```

* 위 코드는 구글 코드이다. 나는 DFS로 구현했다. 
``` markdown
1. 실제 재귀 깊이 계산 \(100\times 100\) 배열의 전체 칸 수는 10,000칸입니다.최악의 경우(모든 칸이 연결된 일자 형태 등) 재귀 깊이가 10,000번까지 들어갈 수 있습니다.Java의 기본 스택 크기(보통 1MB)는 환경에 따라 다르지만, 일반적으로 수천에서 1만 번 정도의 재귀는 충분히 수용합니다. 따라서 이 문제에서 \(N=100\)은 DFS로 충분히 통과 가능한 수치입니다.

2. 그럼에도 왜 BFS나 최적화를 언급하는가? 코딩 테스트 관점에서의 "습관"과 "안전장치" 때문입니다. 입력 크기의 변화: 만약 \(N\)이 500이나 1,000으로 커지면 (\(N^{2}=25\)만~100만), 그때부터는 DFS 재귀 방식이 무조건 StackOverflowError를 일으킵니다.문제의 의도: 많은 그래프 문제들이 BFS/DFS 둘 다 가능하게 나오지만, 일부 까다로운 문제는 재귀 깊이를 의도적으로 깊게 설계하여 DFS를 차단하기도 합니다.Java 언어의 특성: C++은 재귀가 상당히 빠르고 스택 설정이 유연한 편이지만, Java는 상대적으로 재귀 호출 비용이 크고 스택 관리가 엄격한 편이라 실무나 시험에서는 BFS를 선호하는 경향이 있습니다.

# 결론
"이 문제(2468번) 한정으로는 DFS가 전혀 문제없다"가 정답입니다. 백준 2468번의 데이터 범위에서는 질문자님의 코드가 논리적으로 맞다면 DFS로 인해 틀릴 일은 없습니다. 다만, 나중에 \(N\)의 범위가 더 큰 문제를 만나거나 최단 거리를 구해야 할 때는 BFS가 필수라는 점만 기억해 두시면 좋을 것 같습니다. 지금 작성하신 코드는 \(N=100\) 수준에서는 아주 잘 돌아가는 코드입니다!
```