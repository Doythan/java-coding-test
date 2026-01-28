package src.BinarySearch.S2805;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] treeHeight;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        treeHeight = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            treeHeight[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(treeHeight);

        getHeight();
    }

    static void getHeight() {
        int left = 0;
        int right = treeHeight[N - 1];

        while (left <= right) {
            int temp = 0;
            int mid = left + (right - left) / 2;

            for (int i = 0; i < N; i++) {
                if (treeHeight[i] > mid) {
                    temp += treeHeight[i] - mid;
                }
            }

            if (temp == M) {
                if (answer < mid)
                    answer = mid;
                continue;
            }

            if (mid < M) {
                right = mid - 1;
                continue;
            }

            if (mid > M)
                left = mid + 1;

        }
        System.out.println(answer);
    }
}
