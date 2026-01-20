package src.sort.S11000;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] times = new int[N][2];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, Comparator.comparing(a -> a[0]));

        // 강의실 종료시간 관리용 최소 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(times[0][1]); // 첫 강의 종료 시간 

        for (int i=1; i<N; i++) {
            if (pq.peek() <= times[i][0]) pq.poll();
            pq.add(times[i][1]);
        }

        System.out.println(pq.size());
    }
}
