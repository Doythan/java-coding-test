# 강의실 배정

## 참고
``` java
    // 배열 정렬 방식 (3가지) _ 여기서는 2차원 배열 기준 
    // 1
    Arrays.sort(times, Comparator.comparingInt(a -> a[0]));
    Arrays.sort(times, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

    // 2
    Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));
    Arrays.sort(times, (a, b) -> {
        if (a[0] == b[0]) {
            return Integer.compare(a[1], b[1]);
        }
        return Integer.compare(a[0], b[0]);
    });
    // 위 코드를 삼항 연산자로 줄인 버전
    Arrays.sort(times, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

    // 3
    Arrays.sort(times, (a, b) -> a[0] - b[0]);
```

## 코드
``` java
package src.sort.S11000;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] times = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            times[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));

        // 강의실 종료시간 관리용 최소 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(times[0][1]); // 첫 강의 종료시간

        for (int i = 1; i < N; i++) {
            // 가장 빨리 끝나는 강의실과 비교
            if (pq.peek() <= times[i][0]) {
                pq.poll(); // 그 강의실 재사용
            }
            pq.add(times[i][1]); // 새 종료시간 추가
        }

        System.out.println(pq.size());
    }
}
```

### 핵심 로직 한줄 요약

현재 가장 빨리 비는 강의실(pq.peek)과 비교해서 재사용 가능하면 재사용, 아니면 새 강의실 생성

## 우선순위큐란?

쉽게 말하면:

항상 “가장 작은 값” 또는 “가장 큰 값”을 바로 꺼낼 수 있는 큐

일반 큐는 들어온 순서대로 꺼내지만,
우선순위큐는 값의 우선순위에 따라 꺼낸다.

### 이 문제에서는 왜 쓰는가?

우리는 강의실들의 “종료 시간”을 관리해야 한다.

그리고 매번 확인해야 할 것은 단 하나:

가장 빨리 끝나는 강의실이 언제 비느냐

그래서 peek()를 쓰는거다.

### 자주 쓰는 함수들
함수	의미
add(x)	값 넣기
peek()	가장 작은 값 확인 (삭제 안 함)
poll()	가장 작은 값 꺼내기 (삭제)
size()	큐 크기

예시로 보면 바로 이해된다
``` java
PriorityQueue<Integer> pq = new PriorityQueue<>();

pq.add(5);
pq.add(2);
pq.add(8);

System.out.println(pq.peek()); // 2 (가장 작은 값)
System.out.println(pq.poll()); // 2 제거
System.out.println(pq.peek()); // 5
```

즉,
정렬을 유지하는 큐라고 생각하면 된다.

### 최소 힙 / 최대 힙

기본은 최소 힙

최대 힙 쓰고 싶으면 이렇게:

`PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());`


## 결론

겹침 관리 = PriorityQueue

“가장 빠른 종료시간”을 매번 찾아야 한다

그래서 단일 변수(temp)로는 절대 못 푼다