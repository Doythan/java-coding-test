package src.sort;

import java.util.*;

public class SortPracTwo {
    public static void main(String[] args) {
        int arr[][] = {
            {5, 5},
            {5, 4},
            {4, 4},
            {4, 3},
            {1, 1},
            {1, 2},
            {2, 1},
            {2, 2},
            {3, 2},
            {3, 3},
        };

        // 방법 1.
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));  // 오름차순
        Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[0]).reversed());  // 내림차순
        Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));  // 다중 조건: a[0]이 같으면, a[1] 비교
        Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[0]).reversed().thenComparingInt(a -> a[1]).reversed());  // 다중 조건: a[0]이 같으면, a[1] 비교 (내림차순)

        // 방법 2.
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));  // 오름차순
        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));  // 내림차순
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });  // 다중 조건 
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));  // 다중 조건(삼항연산자) 


        // 방법 3.
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);  // 오름차순
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);  // 내림차순 
    }
}
