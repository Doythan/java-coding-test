package src.bfs.S2178;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0, N, M));
    }

    static int bfs(int x, int y, int N, int M) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int curX = current[0];
            int curY = current[1];

            // 도착 지점 도달 시 리턴
            if (curX == N-1 && curY == M-1) {
                return maze[curX][curY];
            }

            for (int i=0; i<4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && maze[nx][ny] == 1) {
                    maze[nx][ny] = maze[curX][curY] + 1;
                    queue.add(new int[]{nx, ny});
                } 
            }

        }
        return maze[N-1][M-1];
    }
}

/* 의문점 + 기본기 공부
질문을 아주 날카롭게 잘 하셨습니다! 이 부분은 자바의 객체 지향 특성과 제네릭(Generic)의 관계를 이해하면 바로 풀립니다.
결론부터 말씀드리면, 1차원 배열은 자바에서 하나의 '객체'로 취급되기 때문에 큐에 쏙 들어가는 것입니다.

1. 큐의 타입 정의를 다시 보세요
    java
    Deque<int[]> queue = new ArrayDeque<>();
    코드를 사용할 때는 주의가 필요합니다.

    여기서 <int[]>의 의미는 "이 큐는 int[]라는 물건(객체)을 하나씩 담는 바구니야"라는 뜻입니다.
2. 메모리 구조로 이해하기 (1차원 vs 2차원)
    우리가 new int[]{x, y}라고 쓰는 것은 1차원 배열입니다. 하지만 큐 입장에서는 그게 몇 차원인지 중요하지 않습니다.
    비유: 큐가 '택배 트럭'이라면, int[]는 안에 내용물(x, y)이 들어있는 '박스 하나'입니다.
    작동 원리:
    new int[]{x, y}를 하면 메모리 어딘가에 [x, y]라는 데이터 박스가 만들어집니다.
    queue.add(...)를 하면 그 박스의 주소(참조값) 하나가 큐에 들어갑니다.
    큐는 [박스1의 주소, 박스2의 주소, 박스3의 주소] 이런 식으로 1차원적인 대기열을 가집니다.
3. 만약 1차원 배열이 아니었다면? (비교)
    1) 그냥 숫자(int)를 담는 큐
        java
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(10); // 그냥 숫자 하나 띡 넣음
        코드를 사용할 때는 주의가 필요합니다.

    2) 배열(int[])을 담는 큐 (현재 케이스)
        java
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 2}); // [1, 2]라는 묶음(객체) 하나를 넣음
        코드를 사용할 때는 주의가 필요합니다.

    여기서 new int[]{1, 2}는 요소가 2개인 1차원 배열입니다.
    큐는 이 1차원 배열 덩어리 자체를 하나의 원소로 취급해서 차곡차곡 쌓는 것입니다.
4. 왜 2차원 배열처럼 느껴지나요?
    큐 자체도 선형 구조(1차원 리스트)인데, 그 안에 들어있는 내용물도 배열(1차원)이기 때문에, 결과적으로 전체 구조를 펼쳐서 보면 [[x1, y1], [x2, y2], ...] 형태의 2차원 데이터 구조처럼 보이게 되는 것입니다.
    요약
    int[]는 자바에서 하나의 데이터 타입입니다.
    queue.add(배열)은 큐라는 한 줄 기차에 '배열'이라는 승객을 한 명씩 태우는 것과 같습니다.
    태워진 승객(배열)이 자기 주머니에 x, y라는 두 개의 데이터를 가지고 있을 뿐입니다.
    이 개념은 자바의 공식 문서(Arrays)나 Collection 인터페이스 설명을 참고하면 더욱 명확해집니다. 이제 poll()을 했을 때 왜 int[] 타입이 튀어나오는지 이해가 되시죠?
    
*/