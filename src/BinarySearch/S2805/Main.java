package src.binarysearch.S2805;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long M; // M도 long으로 받는 것이 안전합니다.
    static int[] treeHeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        treeHeight = new int[N];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            treeHeight[i] = Integer.parseInt(st.nextToken());
            if (treeHeight[i] > max)
                max = treeHeight[i];
        }

        // Arrays.sort는 필수가 아니지만 하셔도 무방합니다.
        // 최댓값만 알면 이분 탐색이 가능하므로 max값만 찾아도 됩니다.

        System.out.println(getHeight(max));
    }

    static long getHeight(int max) {
        long left = 0;
        long right = max;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0; // 반드시 long 타입 사용!

            for (int h : treeHeight) {
                if (h > mid) {
                    sum += (h - mid);
                }
            }

            // 자른 나무의 합이 목표치보다 크거나 같다면 (성공)
            if (sum >= M) {
                answer = mid; // 일단 답으로 기록하고
                left = mid + 1; // 더 높이 자를 수 있는지 확인 (오른쪽 탐색)
            } else {
                // 목표치보다 부족하다면 (실패)
                right = mid - 1; // 더 낮게 잘라야 함 (왼쪽 탐색)
            }
        }
        return answer;
    }
}
