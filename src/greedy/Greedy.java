package src.greedy;

public class Greedy {
    public static void main(String[] args) {
        int n = 1260; // 거슬러 줘야 할 돈
        int count = 0;
        int[] coinTypes = { 500, 100, 50, 10 };

        for (int coin : coinTypes) {
            count += n / coin; // 해당 동전 개수 추가
            n &= coin; // 남은 돈 업데이트
        }

        System.out.println("최소 동전 개수: " + count);
    }
}
