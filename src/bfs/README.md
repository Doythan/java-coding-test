# BFS (Breadth First Search)

## 개념
- 그래프나 트리를 탐색하는 방법
- 시작 정점에서 가까운 노드부터 차례대로 탐색
- Queue(큐)를 사용한다
- 거리, 단계, 최소 횟수를 구할 때 사용

## BFS 기본 템플릿 (인접 리스트)

```java
static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited[start] = true;
    dist[start] = 0;

    while (!queue.isEmpty()) {
        int cur = queue.poll();

        for (int next : graph[cur]) {
            if (!visited[next]) {
                visited[next] = true;
                dist[next] = dist[cur] + 1;
                queue.offer(next);
            }
        }
    }
}
```
👉 거리 배열(dist) 은 BFS에서 거의 항상 같이 쓴다.

## BFS 핵심 규칙 3가지

큐에 넣을 때 방문 체크

poll → 탐색 → offer 순서 유지

한 번 방문한 노드는 다시 안 본다

👉 방문 체크를 poll 할 때 하면 중복 방문 발생한다.

## BFS를 쓰는 대표적인 상황

최단 거리 / 최소 이동 횟수

미로 탐색

숨바꼭질 유형 문제

단계별 탐색이 필요한 경우

가중치가 없는 그래프

## BFS 특징 요약

너비 우선

최단 거리 보장 ✅ (가중치 없을 때)

메모리 사용량 DFS보다 큼

레벨 단위 탐색에 최적