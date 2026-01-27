package src.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9, 11};
        int result = binarySearch(numbers, 7);
        System.out.println("결과 인덱스: " + result);  
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // (left + right) / 2 -> 오버플로우가 발생할 수 도 있다. 

            if (arr[mid] == target) return mid;
            if (arr[mid] < target) {
                left = mid + 1;
                continue;
            }
            if (arr[mid] > target) {
                right = mid - 1;
                continue;
            }
        }

        return -1;  // 값을 찾지 못한 경우 
    }
}
