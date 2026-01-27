package src.BinarySearch.S1920;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, arrTwo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); 
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        arrTwo = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            arrTwo[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<M; i++) {
            int num = arrTwo[i];
            int result = isNumExists(num);
            System.out.println(result);
        }
    }

    public static int isNumExists(int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return 1;
            if (arr[mid] < target) {
                left = mid + 1;
                continue;
            }
            if (arr[mid] > target) {
                right = mid - 1;
                continue;
            }
        }
        return 0;
    }
}
