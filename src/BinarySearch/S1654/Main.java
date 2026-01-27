package src.binarysearch.S1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static int[] arr;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        checkMaxLan(N);
    }

    static void checkMaxLan(int lanNumber) {
        long left = 1;
        long right = arr[K - 1];

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = countLan(mid);
            if (count >= N) {
                answer = Math.max(mid, answer);
                left = mid + 1;
                continue;
            }
            if (count < N) {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    static long countLan(long mid) {
        long count = 0;
        for (int i = 0; i < K; i++) {
            count += arr[i] / mid;
        }

        return count;
    }
}
