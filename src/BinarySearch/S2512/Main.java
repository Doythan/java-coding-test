package src.binarysearch.S2512;

import java.io.*;
import java.util.*;

public class Main {
    static int N; // 지방의 수
    static int M; // 국가 예산 총액
    static int[] budgets; // 지방 요청한 예산들

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        budgets = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());

        int maxRequest = Arrays.stream(budgets).max().getAsInt();

        getMaxBudget(0, maxRequest);
    }

    static void getMaxBudget(int left, int right) {
    }
}
