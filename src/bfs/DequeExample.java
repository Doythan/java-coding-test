package src.bfs;

import java.util.*;

public class DequeExample {
    public static void main(String[] args) {
        // 1. 선언: int 배열(좌표)을 담는 덱 생성
        Deque<int[]> queue = new ArrayDeque<>();

        // 2. 데이터 넣기 (add 또는 addLast)
        // new int[]{x, y} 형태로 배열을 생성해서 넣습니다.
        queue.add(new int[]{0, 0}); // 시작점 (0,0) 삽입
        queue.add(new int[]{0, 1}); // 다음 칸 (0,1) 삽입
        queue.add(new int[]{1, 0}); // 그다음 칸 (1,0) 삽입
        queue.add(new int[]{1, 1}); // 그다음 칸 (1,1) 삽입

        System.out.println("큐 내용: " + queue.stream().map(Arrays::toString).toList());
        System.out.println("큐 내용: " + queue.stream().map(x -> Arrays.toString(x)).toList());
        /* 참고
        1. 문법 하나하나 뜯어보기
            1) .stream() (벨트 가동)
                역할: 큐(queue)에 쌓여 있는 데이터들을 하나씩 차례대로 꺼내서 컨베이어 벨트 위에 올리는 역할입니다.
                이제부터 데이터들은 벨트를 타고 흐르며 가공될 준비를 합니다.
            2) map(Arrays::toString) (가공 공정)
                map(): 벨트 위의 데이터들을 특정 형태로 변환하라는 명령어입니다.
                Arrays::toString: 이게 핵심인데, "Arrays 클래스에 있는 toString 메서드를 사용해라"라는 뜻입니다.
                원래 큐 안에 있던 데이터는 int[] (배열) 형태라 출력하면 이상한 주소값이 나옵니다.
                이걸 Arrays.toString()에 넣어서 "" 처럼 예쁜 문자열(String)로 바꾸는 과정입니다.
            3) :: (메서드 참조 - Method Reference)
                질문하신 :: 기호는 "메서드 참조"라고 부릅니다.
                map(x -> Arrays.toString(x))라고 길게 써야 할 것을 "Arrays의 toString 메서드를 가져다 써!"라고 축약한 표현입니다. 람다식의 더 짧은 버전이라고 생각하시면 됩니다.
            4) .toList() (포장 및 수거)
                역할: 벨트 끝에서 가공된 데이터(문자열들)를 모아서 새로운 리스트(List)로 만드는 역할입니다.
                자바 16 버전부터 지원하는 아주 간결한 문법입니다. (그전에는 .collect(Collectors.toList())라고 길게 썼습니다.)
        2. 그림으로 보는 흐름
                원본 큐: [[I@123, [I@456] (배열 주소값들이 들어있음)
                .stream(): 컨베이어 벨트에 [I@123, [I@456이 차례로 올라감.
                .map(Arrays::toString):
                첫 번째 놈을 가공: [I@123 → ""
                두 번째 놈을 가공: [I@456 → ""
                .toList(): 가공된 문자열들을 모아서 리스트 완성! → ["", ""]
                println: 이제 우리가 읽을 수 있는 예쁜 형태로 출력됩니다.
        3. 요약 (암기용)
                stream(): 데이터를 하나씩 흐르게 한다.
                map(): 데이터를 변환한다.
                ::: 특정 메서드를 지칭하는 지름길 기호.
                toList(): 결과를 리스트로 묶는다.
        */
        int[] polledElement = queue.poll();
        System.out.println("poll 결과(주소값): " + polledElement);
        System.out.println("poll 결과(실제값): " + Arrays.toString(polledElement));
        System.out.println("poll 이후 남은 큐: " + queue.stream().map(Arrays::toString).toList());

        // 3. 데이터 꺼내기 (poll 또는 pollFirst)
        // 큐(FIFO) 방식이므로 가장 먼저 넣은 {0, 0}이 나옵니다.
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 배열 하나를 꺼냄
            int x = current[0]; // 배열의 첫 번째 값
            int y = current[1]; // 배열의 두 번째 값

            System.out.println("꺼낸 좌표: [" + x + ", " + y + "]");
        }
    }
}