package sort.S1931;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getMaxMeetingCount(arr));
        
    }

    private static int getMaxMeetingCount(int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        int cnt = 1;
        int lastIdx = 0;

        for (int i=1; i<meetings.length; i++) {
            if (meetings[lastIdx][1] <= meetings[i][0]) {
                cnt ++;
                lastIdx = i;
            }
        }
        return cnt;
    }
}
