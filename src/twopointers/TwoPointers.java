package src.twopointers;

public class TwoPointers {
    public static void main(String[] args) {
        int n = 5; // 데이터의 개수
        int m = 5; // 찾고자 하는 부분 합
        int[] arr = { 1, 2, 3, 2, 5 };

        int count = 0;
        int intervalSum = 0;
        int end = 0;

        // start를 차례대로 증가시키며 반복
        for (int start = 0; start < n; start++) {
            // end를 가능한 만큼 이동시키기
            while (intervalSum < m && end < n) {
                intervalSum += arr[end];
                end++;
            }

            // 부분합이 m일 때 카운트 증가
            if (intervalSum == m) {
                count++;
            }

            // 다음 루프로 가기 전 start가 가리키던 값을 빼줌
            intervalSum -= arr[start];
        }
        System.out.println("조건을 만족하는 구간 개수: " + count);
    }
}
